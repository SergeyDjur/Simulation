package main.actions;

import main.Coordinates;
import main.entities.Creature;
import main.entities.Entity;
import main.gameMap.GameMap;

import javax.swing.*;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TurnActions {


    public List<Coordinates> getCurrentPositions(GameMap gameMap) {

        return new ArrayList<>(gameMap.getEntityMap().keySet());


    }

    public List<Entity> getEntities(GameMap gameMap) {
        return new ArrayList<>(gameMap.getEntityMap().values());
    }

    public void makeTurn(GameMap gameMap) {
        List<Coordinates> currentPositions = getCurrentPositions(gameMap);
        List<Entity> entities = getEntities(gameMap);
        for (Coordinates current : currentPositions) {
            for (Entity entity : entities) {
                if (entity instanceof Creature) {
                    Coordinates target = ((Creature) entity).makeMove(current);
                    if (gameMap.isCoordinateInsideMap(target) && gameMap.isCoordinateEmpty(target)) {
                        gameMap.moveEntity(current, target);
                    }
                }
            }
        }
    }
}
