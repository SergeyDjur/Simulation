package main.entity;

import main.utils.BFSPathFinder;
import main.Coordinates;
import main.gameMap.GameMap;
import main.utils.EntitySettings;
import main.utils.GameMapUtils;

import java.util.List;

public abstract class Creature extends Entity {
    private Coordinates coordinates;
    protected final Class<? extends Entity> food;
    protected final int speed;
    protected int HP;

    public Creature(Coordinates coordinates, Class<? extends Entity> food, int speed) {
        this.coordinates = coordinates;
        this.food = food;
        this.speed = speed;
        this.HP = EntitySettings.HEALTH;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    protected abstract void interact(GameMap gameMap, Coordinates currentPosition, Coordinates targetPosition);


    public boolean isDead() {
        return this.HP <= 0;
    }

    public boolean isPositionValid(GameMap gameMap) {
        return gameMap.getEntityAtCoordinate(this.coordinates) == this;
    }

    public void makeMove(GameMap gameMap) {
        List<Coordinates> path = BFSPathFinder.findPath(gameMap, this.coordinates, food);
        if (isDead() || !isPositionValid(gameMap)) {
            return;
        }

        if (path.isEmpty()) {
            return;
        }


        int amountSteps = Math.min(this.speed, path.size());
        for (int i = 0; i < amountSteps; i++) {
            Coordinates nextPosition = path.get(i);
            if (gameMap.isCoordinateEmpty(nextPosition)) {
                GameMapUtils.makeMove(gameMap, this.coordinates, nextPosition, this);

            } else {
                interact(gameMap, this.coordinates, nextPosition);
            }
        }


    }

}
