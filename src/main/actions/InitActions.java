package main.actions;

import main.Coordinates;
import main.entity.*;
import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;
import main.utils.RandomCoordinatesGenerator;

import java.util.List;
import java.util.Scanner;

public class InitActions {


    public void placeEntity(GameMap gameMap, Coordinates coordinates, Entity entity) {
        gameMap.setUpEntity(gameMap, coordinates, entity);
    }

    //--------------------------RABBIT------------------------//

    public void placeRabbits(GameMap gameMap, EntityFactory entityFactory) {
        List<Entity> rabbits = entityFactory.createRabbits(gameMap);
        for (Entity rabbit : rabbits) {
            gameMap.setUpEntity(gameMap, RandomCoordinatesGenerator.generate(gameMap), rabbit);
        }
    }

    //--------------------------FOX------------------------//

    private void placeFoxes(GameMap gameMap, EntityFactory entityFactory) {
        List<Entity> foxList = entityFactory.createFoxes(gameMap);
        for (Entity fox : foxList) {
            gameMap.setUpEntity(gameMap, RandomCoordinatesGenerator.generate(gameMap), fox);
        }
    }

    //--------------------------GRASS------------------------//

    private void placeGrass(GameMap gameMap, EntityFactory entityFactory) {
        List<Entity> grassList = entityFactory.createGrass(gameMap);
        for (Entity grass : grassList) {
            gameMap.setUpEntity(gameMap, RandomCoordinatesGenerator.generate(gameMap), grass);
        }
    }

    //--------------------------ROCK------------------------//

    private void placeRocks(GameMap gameMap, EntityFactory entityFactory) {
        List<Entity> rockList = entityFactory.createRocks(gameMap);
        for (Entity rock : rockList) {
            gameMap.setUpEntity(gameMap, RandomCoordinatesGenerator.generate(gameMap), rock);
        }
    }

    //--------------------------TREE------------------------//

    private void placeTrees(GameMap gameMap, EntityFactory entityFactory) {
        List<Entity> treesList = entityFactory.createTrees(gameMap);
        for (Entity tree : treesList) {
            gameMap.setUpEntity(gameMap, RandomCoordinatesGenerator.generate(gameMap), tree);
        }
    }

    public void prepareGame(GameMap gameMap, EntityFactory entityFactory) {
        placeRabbits(gameMap, entityFactory);
        placeFoxes(gameMap, entityFactory);
        placeGrass(gameMap, entityFactory);
        placeRocks(gameMap, entityFactory);
        placeTrees(gameMap, entityFactory);
    }


    public static void main(String[] args) {
        TurnActions turnActions = new TurnActions();
        InitActions initActions = new InitActions();
        EntityFactory entityFactory = new EntityFactory();
        GameMapFactory gameMapFactory = new GameMapFactory();
        GameMap gameMap = gameMapFactory.createGameMap(20, 20);
        GameMapConsoleRenderer gameMapConsoleRenderer = new GameMapConsoleRenderer();

        EntityRenderer entityRenderer = new EntityRenderer();
        initActions.prepareGame(gameMap, entityFactory);

        Scanner scanner = new Scanner(System.in);


        int turnsAmount = 0;
        while (true) {
            System.out.println("press Enter to make next turn or press 'q' to quit :");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                break;
            }
            turnActions.nextTurn(gameMap);
            gameMapConsoleRenderer.render(gameMap, entityRenderer);
            turnsAmount++;
            System.out.println("amount of turns " + " " + turnsAmount);
        }
    }

}
