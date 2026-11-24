package main;

import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;

public class Main {


    public static void main(String[] args) {

        GameMapFactory gameMapFactory = new GameMapFactory();
        GameMap gameMap = gameMapFactory.createGameMap(10, 10);
        EntityFactory entityFactory = new EntityFactory();
        EntityRenderer entityRenderer = new EntityRenderer();
        GameMapConsoleRenderer gameMapConsoleRenderer = new GameMapConsoleRenderer();

        GameController gameController = new GameController(false, false, false, false);
        UserInputThread userInputThread = new UserInputThread(gameController);
        SimulationThread simulationThread = new SimulationThread(gameMapFactory, gameMap, entityFactory, entityRenderer, gameMapConsoleRenderer, gameController);
        userInputThread.start();
        simulationThread.start();
    }
}
