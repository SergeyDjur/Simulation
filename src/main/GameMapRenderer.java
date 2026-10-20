package main;

import main.Map.GameMap;
import main.Map.GameMapFactory;
import main.entities.*;


public class GameMapRenderer {
    private final EntityRenderer entityRenderer;
    private final GameMapFactory gameMapFactory;


    public GameMapRenderer(EntityRenderer entityRenderer, GameMapFactory gameMapFactory) {
        this.entityRenderer = entityRenderer;
        this.gameMapFactory = gameMapFactory;
    }

    public void render(GameMap gameMap, EntityEmoji entityEmoji) {

        for (int rowValue = 0; rowValue < gameMap.getRow(); rowValue++) {
            String emptySpace = entityEmoji.getEmptySpaceEmoji();
            StringBuilder line = new StringBuilder();
            for (int columnValue = 0; columnValue < gameMap.getColumn(); columnValue++) {
                if (gameMap.isCoordinateEmpty(new Coordinates(rowValue, columnValue))) {
                    line.append(emptySpace);
                } else {
                    Entity entity = gameMap.getEntityAtCoordinates(new Coordinates(rowValue, columnValue));
                    EntityRenderer renderer = new EntityRenderer();
                    line.append(renderer.render(entity, entityEmoji));
                }
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        EntityRenderer entityRenderer = new EntityRenderer();
        GameMapFactory factory = new GameMapFactory();
        GameMap map = factory.createGameMap();
        GameMapRenderer renderer = new GameMapRenderer(entityRenderer, factory);
        EntityEmoji emoji = new EntityEmoji();
        renderer.render(map, emoji);
    }
}

