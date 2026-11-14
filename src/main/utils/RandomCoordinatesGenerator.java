package main.utils;

import main.Coordinates;
import main.gameMap.GameMap;

import java.util.Random;

public class RandomCoordinatesGenerator {
    private RandomCoordinatesGenerator() {

    }

    private static final Random random = new Random();

    public static Coordinates generate(GameMap gameMap) {
        int rowPosition = random.nextInt(gameMap.getRow());
        int columnPosition = random.nextInt(gameMap.getColumn());
        return new Coordinates(rowPosition, columnPosition);

    }

}
