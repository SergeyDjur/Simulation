package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.GameSettings;
import main.utils.RandomCoordinatesGenerator;

public class PlaceGrassAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmountGrass = GameSettings.calculateMaxAmountGrass(gameMap);

        for (int placed = 0; placed < maxAmountGrass; placed++) {
            Coordinates grassPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity grass = entityFactory.createEntity(EntityType.GRASS, grassPosition);
            gameMap.setUpEntity(gameMap, grassPosition, grass);
        }
    }


}
