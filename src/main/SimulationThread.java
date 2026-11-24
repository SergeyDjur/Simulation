package main;

import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;

public class SimulationThread extends Thread {
    private final Simulation simulation;

    public SimulationThread(GameMapFactory gameMapFactory, GameMap gameMap, EntityFactory entityFactory, EntityRenderer entityRenderer, GameMapConsoleRenderer gameMapConsoleRenderer, GameController gameController) {
        this.simulation = new Simulation(gameMapFactory, gameMap, entityFactory, entityRenderer, gameMapConsoleRenderer, gameController);
    }

    @Override
    public void run() {
        simulation.startSimulation();
    }
}
