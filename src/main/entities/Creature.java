package main.entities;

import main.Coordinates;

public abstract class Creature extends Entity {
    protected Creature(Coordinates coordinates) {
        super(coordinates);
    }
}
