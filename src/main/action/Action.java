package main.action;

import main.factory.EntityFactory;
import main.gameMap.GameMap;

public interface Action {
    void execute(GameMap gameMap, EntityFactory entityFactory);
}
