package map;

import coordinates.Coordinates;
import entityUtils.EntityType;
import entities.*;

public class GameMapFactory {

    public void createGameMap(EntityFactory entityFactory, GameMap gameMap) {
        gameMap.setUpEntity(new Coordinates(0, 0), entityFactory.createEntity(EntityType.FOX));
        gameMap.setUpEntity(new Coordinates(6, 6), entityFactory.createEntity(EntityType.RABBIT));
        gameMap.setUpEntity(new Coordinates(23, 20), entityFactory.createEntity(EntityType.TREE));
        gameMap.setUpEntity(new Coordinates(11, 6), entityFactory.createEntity(EntityType.STONE));
        gameMap.setUpEntity(new Coordinates(10, 17), entityFactory.createEntity(EntityType.GRASS));

    }

}
