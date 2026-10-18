package main.entities;

import main.Coordinates;

public abstract class Creature extends Entity implements Movable {

    protected Creature(Coordinates coordinates) {
        super(coordinates);
    }
}
