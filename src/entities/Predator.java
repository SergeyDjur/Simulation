package entities;

import entityUtils.EntityType;

public abstract class Predator extends Creature {
    private int attackPower;

    protected Predator(EntityType entityType) {
        super(entityType);
    }

    @Override
    void makeMove() {

    }
}
