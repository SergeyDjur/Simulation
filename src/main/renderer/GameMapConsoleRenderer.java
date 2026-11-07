package main.renderer;

import main.Coordinates;
import main.entity.Entity;
import main.gameMap.GameMap;
import main.entityUtils.EntityEmoji;

public class GameMapConsoleRenderer {
    public void render(GameMap gameMap, EntityEmoji entityEmoji, EntityRenderer entityRenderer) {
        for (int rowValue = 0; rowValue < gameMap.getRow(); rowValue++) {
            StringBuilder line = new StringBuilder();
            for (int columnValue = 0; columnValue < gameMap.getColumn(); columnValue++) {
                Coordinates coordinates = new Coordinates(rowValue, columnValue);
                Entity entity = gameMap.getEntityAtCoordinate(coordinates);
                if (gameMap.isCoordinateEmpty(coordinates)) {
                    line.append(entityEmoji.getEmptySpaceEmoji());
                } else {
                    line.append(entityRenderer.render(entity, entityEmoji));
                }
            }
            System.out.println(line);
        }
    }

}
