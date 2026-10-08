package entities;

import entityUtils.EntityType;

public abstract class Entity {
    private final EntityType entityType;

    protected Entity(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getType() {
        return entityType;
    }

}
