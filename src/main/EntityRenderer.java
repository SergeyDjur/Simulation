package main;

import main.entities.*;

public class EntityRenderer {

    public String render(Entity entity, EntityEmoji entityEmoji) {

        if (entity instanceof Rabbit) {
            return entityEmoji.getRabbitEmoji();
        } else if (entity instanceof Fox) {
            return entityEmoji.getFoxEmoji();
        } else if (entity instanceof Carrot) {
            return entityEmoji.getCarrotEmoji();
        } else if (entity instanceof Grass) {
            return entityEmoji.getGrassEmoji();
        } else if (entity instanceof Rock) {
            return entityEmoji.getRockEmoji();
        } else if (entity instanceof Tree) {
            return entityEmoji.getTreeEmoji();
        } else {
            return entityEmoji.getEmptySpaceEmoji();
        }
    }
}


