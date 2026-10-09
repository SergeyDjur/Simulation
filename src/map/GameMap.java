package map;

import coordinates.Coordinates;
import entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private final int height;
    private final int width;
    Map<Coordinates, Entity> entityHashMap = new HashMap<>();

    public GameMap(int height, int width) {

        this.height = height;
        this.width = width;
    }

    public void setUpEntity(Coordinates coordinates, Entity entity) {
        if (isCoordinateEmpty(coordinates)) {
            entityHashMap.put(coordinates, entity);
        }
    }

    public boolean isCoordinateEmpty(Coordinates coordinates) {
        return !entityHashMap.containsKey(coordinates);
    }


    public Entity getEntityAtCoordinate(Coordinates coordinates) {
        return entityHashMap.get(coordinates);
    }


    public void removeEntity(Coordinates coordinates) {
        entityHashMap.remove(coordinates);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Coordinates, Entity> getEntityHashMap() {
        return entityHashMap;
    }
}
