package main;

import main.action.*;
import main.action.Action;
import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;

import java.util.List;
import java.util.Scanner;


public class Simulation {
    private final GameMapFactory gameMapFactory;

    private final GameMap gameMap;
    private final EntityFactory entityFactory;
    private final EntityRenderer entityRenderer;
    private final GameMapConsoleRenderer gameMapConsoleRenderer;


    public Simulation(GameMapFactory gameMapFactory, GameMap gameMap, EntityFactory entityFactory, EntityRenderer entityRenderer, GameMapConsoleRenderer gameMapConsoleRenderer) {
        this.gameMapFactory = gameMapFactory;

        this.gameMap = gameMap;
        this.entityFactory = entityFactory;
        this.entityRenderer = entityRenderer;
        this.gameMapConsoleRenderer = gameMapConsoleRenderer;
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

        int turnsAmount = 0;
        Scanner scanner = new Scanner(System.in);

        gameMapConsoleRenderer.render(gameMap, entityRenderer);

        System.out.println(turnsAmount);

        executeInitActions();


        while (true) {
            System.out.println("press Enter to make next turn or press 'q' to quit :");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("q")) {
                break;
            }
            executeTurnActions();
            gameMapConsoleRenderer.render(gameMap, entityRenderer);
            turnsAmount++;

            System.out.println();
            System.out.println("amount of turns " + " " + turnsAmount);
        }
    }

}
