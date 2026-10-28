package main.entityUtils;

import main.Coordinates;
import main.entities.*;

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
                return new Grass(coordinates);
            }
            case ROCK -> {
                return new Rock(coordinates);
            }
            case TREE -> {
                return new Tree(coordinates);
            }
            case CARROT -> {
                return new Carrot(coordinates);
            }
            case null, default -> throw new RuntimeException("entity not found");
        }

    }
}
