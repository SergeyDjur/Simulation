package main.Map;

import main.Coordinates;
import main.entities.*;

public class GameMapFactory {

    public GameMap createGameMap() {
        GameMap gameMap = new GameMap(10, 10);
        gameMap.setEntity(new Coordinates(2, 2), new Rabbit());
        gameMap.setEntity(new Coordinates(5, 5), new Carrot());
        gameMap.setEntity(new Coordinates(4, 5), new Rock());
        return gameMap;
    }
}
