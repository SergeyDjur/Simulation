package main.factory;

import main.Coordinates;
import main.entity.*;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.InitActionsUtils;
import main.utils.RandomCoordinatesGenerator;

import java.util.ArrayList;
import java.util.List;


public class EntityFactory {
    public Entity createEntity(EntityType entityType, Coordinates coordinates) {
        switch (entityType) {
            case RABBIT -> {
                return new Rabbit(coordinates);
            }
            case FOX -> {
                return new Fox(coordinates);
            }
            case GRASS -> {
                return new Grass();
            }
            case TREE -> {
                return new Tree();
            }
            case ROCK -> {
                return new Rock();
            }
            case null, default -> throw new RuntimeException("unknown entity type");
        }

    }

    public List<Entity> createRabbits(GameMap gameMap) {
        List<Entity> rabbits = new ArrayList<>();
        int maxAmountRabbits = InitActionsUtils.calculateDefaultPercentRabbits(gameMap);
        for (int i = 0; i < maxAmountRabbits; i++) {
            Entity rabbit = createEntity(EntityType.RABBIT, RandomCoordinatesGenerator.generate(gameMap));
            rabbits.add(rabbit);
        }
        return rabbits;
    }

    public List<Entity> createFoxes(GameMap gameMap) {
        List<Entity> foxes = new ArrayList<>();
        int maxAmountFoxes = InitActionsUtils.calculateDefaultPercentFoxes(gameMap);
        for (int i = 0; i < maxAmountFoxes; i++) {
            Entity rabbit = createEntity(EntityType.FOX, RandomCoordinatesGenerator.generate(gameMap));
            foxes.add(rabbit);
        }
        return foxes;
    }

    public List<Entity> createGrass(GameMap gameMap) {
        List<Entity> grassList = new ArrayList<>();
        int maxAmountGrass = InitActionsUtils.calculateDefaultPercentGrass(gameMap);
        for (int i = 0; i < maxAmountGrass; i++) {
            Entity grass = createEntity(EntityType.GRASS, RandomCoordinatesGenerator.generate(gameMap));
            grassList.add(grass);
        }
        return grassList;
    }

    public List<Entity> createRocks(GameMap gameMap) {
        List<Entity> rockList = new ArrayList<>();
        int maxAmountRocks = InitActionsUtils.calculateDefaultPercentRocks(gameMap);
        for (int i = 0; i < maxAmountRocks; i++) {
            Entity rock = createEntity(EntityType.ROCK, RandomCoordinatesGenerator.generate(gameMap));
            rockList.add(rock);
        }
        return rockList;
    }

    public List<Entity> createTrees(GameMap gameMap) {
        List<Entity> treesList = new ArrayList<>();
        int maxAmountTrees = InitActionsUtils.calculateDefaultPercentTrees(gameMap);
        for (int i = 0; i < maxAmountTrees; i++) {
            Entity tree = createEntity(EntityType.TREE, RandomCoordinatesGenerator.generate(gameMap));
            treesList.add(tree);
        }
        return treesList;
    }

}


