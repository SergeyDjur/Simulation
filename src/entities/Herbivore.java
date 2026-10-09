package entities;

import entityUtils.EntityType;

public abstract class Herbivore extends Creature {

    protected Herbivore(EntityType entityType) {
        super(entityType);
    }

    @Override
    void makeMove() {

    }
}
