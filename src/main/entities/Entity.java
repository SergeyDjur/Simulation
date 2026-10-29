package main.entities;

import main.Coordinates;

public abstract class Entity {
    private Coordinates coordinates;

    protected Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract String getEmoji();

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
