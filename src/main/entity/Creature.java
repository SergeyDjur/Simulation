package main.entity;

import main.Coordinates;

public class Creature extends Entity {
    private final Coordinates coordinates;

    public Creature(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
