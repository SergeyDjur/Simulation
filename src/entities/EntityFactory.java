package entities;

import entityUtils.EntityType;

public class EntityFactory {
    public Entity createEntity(EntityType entityType) {
        return switch (entityType) {
            case RABBIT -> new Rabbit();
            case FOX -> new Fox();
            case TREE -> new Tree();
            case GRASS -> new Grass();
            case STONE -> new Stone();
        };
    }

    public static void main(String[] args) {
        EntityFactory factory = new EntityFactory();
        Entity entity = factory.createEntity(EntityType.FOX);
        System.out.println(entity.getType());
    }

}
