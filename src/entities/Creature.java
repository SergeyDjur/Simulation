package entities;

import entityUtils.EntityType;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;

    protected Creature(EntityType entityType) {
        super(entityType);
    }

    abstract void makeMove();

}
