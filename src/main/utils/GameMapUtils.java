package main.utils;

import main.Coordinates;
import main.entity.Creature;
import main.entity.Entity;
import main.entity.Grass;
import main.entity.Rabbit;
import main.gameMap.GameMap;

import java.util.Map;

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

    private static int calculateRestRabbits(Map<Coordinates, Entity> entities) {
        int restRabbits = 0;

        for (Map.Entry<Coordinates, Entity> entryGrass : entities.entrySet()) {
            Entity entity = entryGrass.getValue();
            String name = entity.getClass().getSimpleName();
            if (name.equals(Rabbit.class.getSimpleName())) {
                restRabbits++;
            }

        }
        return restRabbits;
    }

    private static int calculateRestGrass(Map<Coordinates, Entity> entities) {
        int restGrass = 0;
        for (Map.Entry<Coordinates, Entity> entryGrass : entities.entrySet()) {
            Entity entity = entryGrass.getValue();
            String name = entity.getClass().getSimpleName();
            if (name.equals(Grass.class.getSimpleName())) {
                restGrass++;
            }
        }
        return restGrass;
    }

    public static boolean isLessMinAmountGrass(GameMap gameMap) {
        int restGrass = calculateRestGrass(gameMap.getEntities());
        return restGrass <= EntitySettings.MIN_AMOUNT_GRASS;
    }

    public static boolean isLessMinAmountRabbits(GameMap gameMap) {
        int restRabbits = calculateRestRabbits(gameMap.getEntities());
        return restRabbits <= EntitySettings.MIN_AMOUNT_RABBITS;
    }


}
