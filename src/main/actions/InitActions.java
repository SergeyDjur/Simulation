package main.actions;

import main.Coordinates;
import main.entities.Entity;
import main.entityUtils.EntityFactory;
import main.entityUtils.EntityType;
import main.gameMap.GameMap;

public class InitActions {
    //actions before start simulation :
    // - setUp all entities on the map

    private final EntityFactory entityFactory;

    public InitActions(EntityFactory entityFactory) {

        this.entityFactory = entityFactory;

    }

    private void placeEntityOnMap(GameMap gameMap, EntityType entityType, Coordinates coordinates) {
        if (!gameMap.isCoordinateInsideMap(coordinates)) {

            throw new IllegalArgumentException("coordinate" + coordinates + "outside the map");
        }
            if (!gameMap.isCoordinateEmpty(coordinates)) {
                throw new IllegalArgumentException("coordinate " + coordinates + "already taken");
            }

            Entity entity = entityFactory.createEntity(entityType, coordinates);
            gameMap.setUpEntity(coordinates, entity);

    }

    public void prepareGame(GameMap gameMap) {
        placeEntityOnMap(gameMap, EntityType.RABBIT, new Coordinates(3, 3));
        placeEntityOnMap(gameMap, EntityType.FOX, new Coordinates(5, 5));
        placeEntityOnMap(gameMap, EntityType.GRASS, new Coordinates(2, 7));
        placeEntityOnMap(gameMap, EntityType.ROCK, new Coordinates(2, 4));
        placeEntityOnMap(gameMap, EntityType.TREE, new Coordinates(3, 1));
        placeEntityOnMap(gameMap, EntityType.CARROT, new Coordinates(8, 4));
    }
}
