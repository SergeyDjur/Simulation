package main.gameMap;

import main.Coordinates;
import main.entities.Entity;
import main.entityUtils.EntityEmoji;
import main.entityUtils.EntityRenderer;

public class GameMapRenderer {
    private final EntityRenderer entityRenderer;

    public GameMapRenderer(EntityRenderer entityRenderer) {

        this.entityRenderer = entityRenderer;
    }

    public void render(GameMap gameMap, EntityEmoji entityEmoji) {
        for (int rowValue = 0; rowValue < gameMap.getRow(); rowValue++) {
            String emptySpace = entityEmoji.getEmptySpaceEmoji();
            StringBuilder line = new StringBuilder();
            for (int columnValue = 0; columnValue < gameMap.getColumn(); columnValue++) {
                Coordinates coordinates = new Coordinates(rowValue, columnValue);

                if (gameMap.isCoordinateEmpty(coordinates)) {
                    line.append(emptySpace);
                } else {
                    Entity entity = gameMap.getEntityAtCoordinate(coordinates);
                    line.append(entityRenderer.render(entity));
                }
            }
            System.out.println(line);
        }
    }

}
