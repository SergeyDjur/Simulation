package main.entityUtils;

import main.entities.Entity;

public class EntityRenderer {
    private final EntityEmoji entityEmoji;

    public EntityRenderer(EntityEmoji entityEmoji) {
        this.entityEmoji = entityEmoji;
    }

    public String render(Entity entity) {
        if (entity == null) {
            return entityEmoji.getEmptySpaceEmoji();
        }
        return entity.getEmoji();
    }
}
