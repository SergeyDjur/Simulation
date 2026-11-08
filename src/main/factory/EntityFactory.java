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

}


