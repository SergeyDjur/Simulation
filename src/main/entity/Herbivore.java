package main.entity;

import main.Coordinates;

public abstract class Herbivore extends Creature {
    protected static final Class<? extends Entity> FOOD = Grass.class;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, FOOD);
    }
}
