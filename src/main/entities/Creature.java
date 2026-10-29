package main.entities;

import main.Coordinates;

public abstract class Creature extends Entity {
    protected Creature(Coordinates coordinates) {
        super(coordinates);
    }

    /*
    the point of this method is to accept current coordinates of entity from hashMap
    and return target coordinates

     */
    public abstract Coordinates makeMove(Coordinates currentPosition);
}
