package main.Map;

import main.Coordinates;
import main.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private int row;
    private int column;

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public GameMap(int row, int column) {
        this.row = row;
        this.column = column;
    }


    public void setEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);

    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public Map<Coordinates, Entity> getEntities() {
        return entities;
    }

    public Entity getEntityAtCoordinates(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
