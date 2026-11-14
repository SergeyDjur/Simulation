package main.entity;

import main.Coordinates;
import main.gameMap.GameMap;
import main.utils.GameMapUtils;


public class Rabbit extends Herbivore {
    public Rabbit(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    protected void interact(GameMap gameMap, Coordinates currentPosition, Coordinates targetPosition) {

        Entity entityTarget = gameMap.getEntityAtCoordinate(targetPosition);

        if (super.food.isInstance(entityTarget)) {
            gameMap.removeEntity(targetPosition);
            GameMapUtils.makeMove(gameMap, currentPosition, targetPosition, this);
        }

    }

    @Override
    public void makeMove(GameMap gameMap,Coordinates currentPosition) {
        super.makeMove(gameMap, currentPosition);
    }
}
