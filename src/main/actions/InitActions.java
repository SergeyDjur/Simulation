package main.actions;

import main.Coordinates;
import main.entity.*;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.InitActionsUtils;
import main.utils.RandomCoordinatesGenerator;

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

}
