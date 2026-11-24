package main;

import main.action.*;
import main.action.Action;
import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;
import main.utils.GameMapUtils;

import java.util.List;

public class Simulation {
    private final GameMapFactory gameMapFactory;

    private final GameMap gameMap;
    private final EntityFactory entityFactory;
    private final EntityRenderer entityRenderer;
    private final GameMapConsoleRenderer gameMapConsoleRenderer;
    private final GameController gameController;


    public Simulation(GameMapFactory gameMapFactory, GameMap gameMap, EntityFactory entityFactory, EntityRenderer entityRenderer, GameMapConsoleRenderer gameMapConsoleRenderer, GameController gameController) {
        this.gameMapFactory = gameMapFactory;

        this.gameMap = gameMap;
        this.entityFactory = entityFactory;
        this.entityRenderer = entityRenderer;
        this.gameMapConsoleRenderer = gameMapConsoleRenderer;
        this.gameController = gameController;
    }

    List<Action> initActions = List.of(new PlaceRabbitsAction(), new PlaceGrassAction(), new PlaceFoxesAction(), new PlaceRocksAction(), new PlaceTreesAction());
    List<Action> turnActions = List.of(new MoveAllCreaturesAction());


    public void executeInitActions() {
        for (Action a : initActions) {
            a.execute(gameMap, entityFactory);

        }
    }

    public void executeTurnActions() {
        for (Action b : turnActions) {
            b.execute(gameMap, entityFactory);
        }
    }

    public void startSimulation() {

        executeInitActions();
        int turnsAmount = 0;

        try {
            while (true) {
                boolean isStopped = gameController.getIsPaused();
                boolean isEndlessLoop = gameController.getIsStartSimulation();
                boolean isNextTurn = gameController.getIsNextTurn();
                boolean isQuit = gameController.getIsQuit();
                if (isQuit) {
                    break;
                }
                if (isStopped) {
                    Thread.sleep(1000);
                }
                if (isNextTurn || isEndlessLoop) {
                    if (GameMapUtils.isLessMinAmountGrass(gameMap)) {
                        Action addGrass = new PlaceGrassAction();
                        addGrass.execute(gameMap, entityFactory);
                    }
                    if (GameMapUtils.isLessMinAmountRabbits(gameMap)) {
                        Action addRabbits = new PlaceRabbitsAction();
                        addRabbits.execute(gameMap, entityFactory);
                    }
                    executeTurnActions();
                    gameMapConsoleRenderer.render(gameMap, entityRenderer);
                    System.out.println();
                    turnsAmount++;
                    System.out.println("amount of turns " + " " + turnsAmount);
                    Thread.sleep(1000);
                    gameController.setNextTurn(false);
                }


            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
