package main.action;

import main.Coordinates;
import main.entity.Creature;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.gameMap.GameMap;

import java.util.Map;

public class MoveAllCreaturesAction implements Action {
    @Override
    public void execute(GameMap gameMap, EntityFactory entityFactory) {
        Map<Coordinates, Entity> entities = gameMap.getEntities();

        for (Map.Entry<Coordinates, Entity> entityEntry : entities.entrySet()) {

            Entity entity = entityEntry.getValue();
            if (entity instanceof Creature) {

                ((Creature) entity).makeMove(gameMap);
            }

        }
    }
}
