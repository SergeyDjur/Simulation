package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.GameSettings;
import main.utils.RandomCoordinatesGenerator;

public class PlaceFoxesAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int maxAmountFoxes = GameSettings.calculateMaxAmountFoxes(gameMap);

        for (int placed = 0; placed < maxAmountFoxes; placed++) {
            Coordinates foxPosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity fox = entityFactory.createEntity(EntityType.FOX, foxPosition);
            gameMap.setUpEntity(gameMap, foxPosition, fox);
        }
    }


}
