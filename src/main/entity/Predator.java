package main.entity;

import main.Coordinates;

public abstract class Predator extends Creature {
    protected static final Class<? extends Entity> FOOD = Herbivore.class;

    public Predator(Coordinates coordinates) {
        super(coordinates, FOOD);

    }
}
