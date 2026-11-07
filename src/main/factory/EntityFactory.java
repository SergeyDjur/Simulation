package main.factory;

import main.Coordinates;
import main.entity.*;
import main.entityUtils.EntityType;

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

    public static void main(String[] args) {
        EntityFactory factory = new EntityFactory();
        Entity entity = factory.createEntity(EntityType.RABBIT, new Coordinates(1, 1));

    }
}
