package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.InitActionsUtils;
import main.utils.RandomCoordinatesGenerator;

public class PlaceRabbitsAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int defaultAmountRabbits = InitActionsUtils.calculateDefaultPercentRabbits(gameMap);
        for (int placed = 0; placed < defaultAmountRabbits; placed++) {
            Coordinates rabbitPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity rabbit = entityFactory.createEntity(EntityType.RABBIT, rabbitPosition);
            gameMap.setUpEntity(gameMap, rabbitPosition, rabbit);
        }
    }
}
