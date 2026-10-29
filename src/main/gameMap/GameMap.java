package main.gameMap;

import main.Coordinates;
import main.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private int row;
    private int column;

    public GameMap(int row, int column) {
        this.row = row;
        this.column = column;
    }

    Map<Coordinates, Entity> entityMap = new HashMap<>();

    public void setUpEntity(Coordinates coordinates, Entity entity) {
        entityMap.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        entityMap.remove(coordinates);
    }

    public Entity getEntityAtCoordinate(Coordinates coordinates) {
        return entityMap.get(coordinates);
    }


    public void moveEntity(Coordinates currentPosition, Coordinates targetPosition) {
        Entity entity = getEntityAtCoordinate(currentPosition);
        removeEntity(currentPosition);
        setUpEntity(targetPosition, entity);
    }


    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entityMap.containsKey(coordinates);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isCoordinateInsideMap(Coordinates coordinates) {
        return coordinates.row() >= 0 && coordinates.row() <= row - 1 && coordinates.column() >= 0 && coordinates.column() <= column - 1;
    }

    public Map<Coordinates, Entity> getEntityMap() {
        return entityMap;
    }

}
