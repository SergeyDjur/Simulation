package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;

import main.utils.GameMapUtils;
import main.utils.GameSettings;
import main.utils.RandomCoordinatesGenerator;

public class PlaceRabbitsAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmountRabbits = GameSettings.calculateMaxAmountRabbits(gameMap);
        int restRabbits = GameMapUtils.calculateRestRabbits(gameMap);
        int missingRabbits = maxAmountRabbits - restRabbits;
        for (int placed = 0; placed < missingRabbits; placed++) {
            Coordinates rabbitPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity rabbit = entityFactory.createEntity(EntityType.RABBIT, rabbitPosition);
            gameMap.setUpEntity(gameMap, rabbitPosition, rabbit);
        }
    }


}
