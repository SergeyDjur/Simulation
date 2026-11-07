package main.renderer;

import main.entity.*;
import main.utils.EntityEmoji;


public class EntityRenderer {
    public String render(Entity entity) {
        if (entity instanceof Rabbit) {
            return EntityEmoji.rabbitEmoji;
        }
        if (entity instanceof Fox) {
            return EntityEmoji.foxEmoji;
        }
        if (entity instanceof Grass) {
            return EntityEmoji.grassEmoji;
        }
        if (entity instanceof Rock) {
            return EntityEmoji.rockEmoji;
        }
        if (entity instanceof Tree) {
            return EntityEmoji.treeEmoji;
        }
        return EntityEmoji.emptySpaceEmoji;
    }
}
