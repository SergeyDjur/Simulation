package entities;

import entityUtils.EntityEmoji;


public class EntityRenderer {
    private final EntityEmoji emoji;

    public EntityRenderer(EntityEmoji emoji) {
        this.emoji = emoji;
    }

    public String render(Entity entity) {
        switch (entity.getType()) {
            case TREE -> {
                return emoji.getTREE();
            }
            case STONE -> {
                return emoji.getSTONE();
            }
            case GRASS -> {
                return emoji.getGRASS();
            }
            case FOX -> {
                return emoji.getFOX();
            }
            case RABBIT -> {
                return emoji.getRABBIT();
            }
        }
        return "emoji not found";
        //I don't like this return,I need to find out how to fix it
    }


    public static void main(String[] args) {
        EntityEmoji emoji = new EntityEmoji();
        EntityRenderer renderer = new EntityRenderer(emoji);
        String fox = renderer.render(new Fox());
        System.out.println(fox);
    }
}
