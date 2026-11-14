package main.utils;

import main.Coordinates;
import main.entity.Creature;
import main.entity.Entity;
import main.gameMap.GameMap;

public class GameMapUtils {
    private GameMapUtils() {

    }

    public static void validate(GameMap gameMap, Coordinates coordinates) {

        if (coordinates.row() >= 0 && coordinates.row() < gameMap.getRow() && coordinates.column() >= 0 && coordinates.column() < gameMap.getColumn()) {
            return;
        }
        throw new IllegalArgumentException(coordinates + " is out of bounds");
    }

    public static boolean isInsideMap(GameMap gameMap, Coordinates neighbour) {
        return neighbour.row() >= 0 && neighbour.row() < gameMap.getRow() && neighbour.column() >= 0 && neighbour.column() < gameMap.getColumn();
    }


    public static void makeMove(GameMap gameMap, Coordinates currentPosition, Coordinates nextPosition, Entity entity) {

        gameMap.removeEntity(currentPosition);
        gameMap.setUpEntity(gameMap, nextPosition, entity);
        if (entity instanceof Creature creature) {
            creature.setCoordinates(nextPosition);
        }

    }


}
