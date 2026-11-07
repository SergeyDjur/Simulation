package main.renderer;

import main.entity.*;
import main.entityUtils.EntityEmoji;


public class EntityRenderer {
    public String render(Entity entity, EntityEmoji entityEmoji) {
        if (entity instanceof Rabbit) {
            return entityEmoji.getRabbitEmoji();
        }
        if (entity instanceof Fox) {
            return entityEmoji.getFoxEmoji();
        }
        if (entity instanceof Grass) {
            return entityEmoji.getGrassEmoji();
        }
        if (entity instanceof Rock) {
            return entityEmoji.getRockEmoji();
        }
        if (entity instanceof Tree) {
            return entityEmoji.getTreeEmoji();
        }
        return entityEmoji.getEmptySpaceEmoji();
    }
}
