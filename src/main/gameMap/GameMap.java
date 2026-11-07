package main.gameMap;

import main.Coordinates;
import main.entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {
    private int row;
    private int column;

    public GameMap(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public void setUpEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public Collection<Entity> getEntities() {
        return List.copyOf(entities.values());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
