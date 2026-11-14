package main.actions;

import main.Coordinates;
import main.entity.Creature;
import main.entity.Entity;

import main.gameMap.GameMap;

import java.util.Map;


public class TurnActions {
    public void nextTurn(GameMap gameMap) {

        Map<Coordinates, Entity> entities = gameMap.getEntities();

        for (Map.Entry<Coordinates, Entity> entryMap : entities.entrySet()) {
            Entity movable = entryMap.getValue();
            if (movable instanceof Creature creature) {
                creature.makeMove(gameMap, entryMap.getKey());
            }

        }

    }
}

