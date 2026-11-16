package main.actions;

import main.Coordinates;
import main.entity.*;
import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;
import main.utils.EntityType;
import main.utils.InitActionsUtils;
import main.utils.RandomCoordinatesGenerator;

import java.util.Scanner;

public class InitActions {


    public void placeEntity(GameMap gameMap, Coordinates coordinates, Entity entity) {
        gameMap.setUpEntity(gameMap, coordinates, entity);
    }

    //--------------------------RABBIT------------------------//


    public void placeRabbits(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmount = InitActionsUtils.calculateDefaultPercentRabbits(gameMap);

        for (int placed = 0; placed < maxAmount; placed++) {
            Coordinates rabbitPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity rabbit = entityFactory.createEntity(EntityType.RABBIT, rabbitPosition);
            gameMap.setUpEntity(gameMap, rabbitPosition, rabbit);
        }
    }

    //--------------------------FOX------------------------//


    public void placeFoxes(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmount = InitActionsUtils.calculateDefaultPercentFoxes(gameMap);

        for (int placed = 0; placed < maxAmount; placed++) {
            Coordinates foxPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity fox = entityFactory.createEntity(EntityType.FOX, foxPosition);
            gameMap.setUpEntity(gameMap, foxPosition, fox);
        }
    }

    //--------------------------GRASS------------------------//


    public void placeGrass(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmount = InitActionsUtils.calculateDefaultPercentGrass(gameMap);

        for (int placed = 0; placed < maxAmount; placed++) {
            Coordinates grassPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity grass = entityFactory.createEntity(EntityType.GRASS, grassPosition);
            gameMap.setUpEntity(gameMap, grassPosition, grass);
        }
    }

    //--------------------------ROCK------------------------//

    public void placeRocks(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmount = InitActionsUtils.calculateDefaultPercentRocks(gameMap);

        for (int placed = 0; placed < maxAmount; placed++) {
            Coordinates rockPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity rock = entityFactory.createEntity(EntityType.ROCK, rockPosition);
            gameMap.setUpEntity(gameMap, rockPosition, rock);
        }
    }


    //--------------------------TREE------------------------//

    public void placeTrees(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmount = InitActionsUtils.calculateDefaultPercentTrees(gameMap);

        for (int placed = 0; placed < maxAmount; placed++) {
            Coordinates treePosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity tree = entityFactory.createEntity(EntityType.TREE, treePosition);
            gameMap.setUpEntity(gameMap, treePosition, tree);
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


        /*
        initActions.placeEntity(gameMap, new Coordinates(0, 10), new Grass());
        initActions.placeEntity(gameMap, new Coordinates(0, 10), new Rabbit(new Coordinates(0, 10)));

         */


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
            System.out.println();
            System.out.println("amount of turns " + " " + turnsAmount);
        }
    }

}
