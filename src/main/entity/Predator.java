package main.entity;

import main.Coordinates;

public abstract class Predator extends Creature {
    protected static final Class<? extends Entity> FOOD = Herbivore.class;
    protected final int powerAttack;

    public Predator(Coordinates coordinates, int speed, int powerAttack) {
        super(coordinates, FOOD, speed);
        this.powerAttack = powerAttack;
    }
}
