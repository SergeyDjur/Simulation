package main.gameMap;

import main.Coordinates;
import main.entity.Entity;
import main.utils.GameMapUtils;

import java.util.*;

public class GameMap {
    private int row;
    private int column;

    public GameMap(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public void setUpEntity(GameMap gameMap, Coordinates coordinates, Entity entity) {
        GameMapUtils.validate(gameMap, coordinates);
        if (isCoordinateEmpty(coordinates)) {
            entities.put(coordinates, entity);

        }
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntityAtCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public Map<Coordinates, Entity> getEntities() {
        return new HashMap<>(entities);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
