package main.action;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;
import main.utils.EntityType;
import main.utils.RandomCoordinatesGenerator;

public class PlaceTreesAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        int defaultAmountTrees = calculateDefaultPercentTrees(gameMap);

        for (int placed = 0; placed < defaultAmountTrees; placed++) {
            Coordinates treePosition = RandomCoordinatesGenerator.generate(gameMap);
            Entity tree = entityFactory.createEntity(EntityType.TREE, treePosition);
            gameMap.setUpEntity(gameMap, treePosition, tree);
        }
    }

    private int calculateDefaultPercentTrees(GameMap gameMap) {
        double treesDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) treesDefaultPercent;
    }
}
