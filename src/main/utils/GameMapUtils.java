package main.utils;

import main.Coordinates;
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

}
