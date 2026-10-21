package main;

import main.entities.*;

public class EntityFactory {

    public Entity createEntities(EntityType entityType) {


        switch (entityType) {
            case FOX -> {
                return new Fox();
            }
            case RABBIT -> {
                return new Rabbit();
            }
            case CARROT -> {
                return new Carrot();
            }
            case ROCK -> {
                return new Rock();
            }
            case TREE -> {
                return new Tree();
            }
            case GRASS -> {
                return new Grass();
            }
            case null, default -> throw new IllegalArgumentException("entity not found");
        }
    }
}
