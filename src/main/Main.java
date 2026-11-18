package main;

import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;

public class Main {


    public static void main(String[] args) {

        GameMapFactory gameMapFactory = new GameMapFactory();
        GameMap gameMap = gameMapFactory.createGameMap(20, 20);
        EntityFactory entityFactory = new EntityFactory();
        EntityRenderer entityRenderer = new EntityRenderer();
        GameMapConsoleRenderer gameMapConsoleRenderer = new GameMapConsoleRenderer();


        Simulation simulation = new Simulation(gameMapFactory, gameMap, entityFactory, entityRenderer, gameMapConsoleRenderer);


        simulation.startSimulation();
    }
}
