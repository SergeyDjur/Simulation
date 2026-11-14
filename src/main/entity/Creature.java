package main.entity;

import main.utils.BFSPathFinder;
import main.Coordinates;
import main.gameMap.GameMap;
import main.utils.GameMapUtils;

import java.util.List;

public abstract class Creature extends Entity {
    private Coordinates coordinates;
    protected final Class<? extends Entity> food;

    public Creature(Coordinates coordinates, Class<? extends Entity> food) {
        this.coordinates = coordinates;
        this.food = food;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    protected abstract void interact(GameMap gameMap, Coordinates currentPosition, Coordinates targetPosition);

    public void makeMove(GameMap gameMap, Coordinates currentPosition) {
        if (gameMap.getEntityAtCoordinate(currentPosition) != this) {
            return;
        }

        List<Coordinates> path = BFSPathFinder.findPath(gameMap, currentPosition, food);


        if (gameMap.getEntityAtCoordinate(currentPosition) != this) {
            return;
        }

        if (path.isEmpty()) {
            return;
        }
        Coordinates nextPosition = path.get(1);
        if (gameMap.isCoordinateEmpty(nextPosition)) {
            GameMapUtils.makeMove(gameMap, currentPosition, nextPosition, this);
        } else {
            interact(gameMap, currentPosition, nextPosition);
        }

    }


}
