package main;

import main.entities.*;

public class EntityFactory {

    public Entity createEntities(EntityType entityType, Coordinates coordinates) {


        switch (entityType) {
            case FOX -> {
                return new Fox(coordinates);
            }
            case RABBIT -> {
                return new Rabbit(coordinates);
            }
            case CARROT -> {
                return new Carrot(coordinates);
            }
            case ROCK -> {
                return new Rock(coordinates);
            }
            case TREE -> {
                return new Tree(coordinates);
            }
            case GRASS -> {
                return new Grass(coordinates);
            }
            case null, default -> throw new IllegalArgumentException("entity not found");
        }
    }
}
