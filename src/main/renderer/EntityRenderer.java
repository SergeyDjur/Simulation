package main.renderer;

import main.entityUtils.EntityEmoji;
import main.entityUtils.EntityType;

public class EntityRenderer {
    public String render(EntityType entityType, EntityEmoji entityEmoji) {
        switch (entityType) {
            case RABBIT -> {
                return entityEmoji.getRabbitEmoji();
            }
            case FOX -> {
                return entityEmoji.getFoxEmoji();
            }
            case GRASS -> {
                return entityEmoji.getGrassEmoji();
            }
            case ROCK -> {
                return entityEmoji.getRockEmoji();
            }
            case TREE -> {
                return entityEmoji.getTreeEmoji();
            }
            case null, default -> {
                return entityEmoji.getEmptySpaceEmoji();
            }
        }
    }

    public static void main(String[] args) {
        EntityRenderer renderer = new EntityRenderer();
        EntityEmoji entityEmoji = new EntityEmoji();
        String testEmoji = renderer.render(EntityType.RABBIT,entityEmoji);
        System.out.println(testEmoji);
        String testEmoji2 = entityEmoji.getEmptySpaceEmoji();
        System.out.println(testEmoji2);
    }
}
