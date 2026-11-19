package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.GameSettings;
import main.utils.RandomCoordinatesGenerator;

public class PlaceRocksAction implements Action {

    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmountRocks = GameSettings.calculateMaxAmountRocks(gameMap);

        for (int placed = 0; placed < maxAmountRocks; placed++) {
            Coordinates rockPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity rock = entityFactory.createEntity(EntityType.ROCK, rockPosition);
            gameMap.setUpEntity(gameMap, rockPosition, rock);
        }
    }


}
