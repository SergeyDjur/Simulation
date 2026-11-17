package main.entity;

import main.Coordinates;
import main.gameMap.GameMap;

import main.utils.EntitySettings;
import main.utils.GameMapUtils;


public class Fox extends Predator {


    public Fox(Coordinates coordinates) {
        super(coordinates, EntitySettings.FOX_SPEED, EntitySettings.FOX_POWER_ATTACK);
    }

    @Override
    protected void interact(GameMap gameMap, Coordinates currentPosition, Coordinates targetPosition) {

        Creature entityTarget = (Creature) gameMap.getEntityAtCoordinate(targetPosition);
        if (super.food.isInstance(entityTarget)) {
            int restTargetHP = entityTarget.HP - this.powerAttack;
            entityTarget.setHP(restTargetHP);
            if (restTargetHP <= EntitySettings.MIN_HEALTH) {
                gameMap.removeEntity(targetPosition);
                GameMapUtils.makeMove(gameMap, currentPosition, targetPosition, this);
            }

        }

    }

}
