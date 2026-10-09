package map;

import coordinates.Coordinates;
import entityUtils.EntityEmoji;
import entities.*;

public class GameMapRenderer {
    private final EntityFactory entityFactory;
    private final GameMapFactory gameMapFactory;
    private final GameMap gameMap;

    public GameMapRenderer(EntityFactory entityFactory, GameMap gameMap, GameMapFactory gameMapFactory) {
        this.entityFactory = entityFactory;
        this.gameMap = gameMap;
        this.gameMapFactory = gameMapFactory;
    }


    public void render(GameMap gameMap, EntityRenderer entityRenderer) {
        gameMapFactory.createGameMap(entityFactory, gameMap);
        for (int i = 0; i < gameMap.getHeight(); i++) {
            StringBuilder line = new StringBuilder();
            String emptySpace = " -- ";
            for (int j = 0; j < gameMap.getWidth(); j++) {

                if (gameMap.isCoordinateEmpty(new Coordinates(i, j))) {
                    line.append(emptySpace);
                } else {
                    line.append(entityRenderer.render(gameMap.getEntityAtCoordinate(new Coordinates(i, j))));
                }
            }
            System.out.println(line);
        }

    }

    public static void main(String[] args) {
        GameMap gameMap = new GameMap(45, 30);
        EntityEmoji emoji = new EntityEmoji();
        EntityRenderer entityRenderer = new EntityRenderer(emoji);
        GameMapFactory mapFactory = new GameMapFactory();
        EntityFactory entityFactory = new EntityFactory();
        GameMapRenderer renderer = new GameMapRenderer(entityFactory, gameMap, mapFactory);
        renderer.render(gameMap, entityRenderer);

    }

}







