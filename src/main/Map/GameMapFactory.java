package main.Map;

import main.Coordinates;
import main.entities.*;

public class GameMapFactory {

    public GameMap createGameMap() {
        GameMap gameMap = new GameMap(10, 10);
        gameMap.setEntity(new Coordinates(2, 2), new Rabbit(new Coordinates(2, 2)));
        gameMap.setEntity(new Coordinates(5, 5), new Carrot(new Coordinates(5, 5)));
        gameMap.setEntity(new Coordinates(4, 5), new Rock(new Coordinates(4, 5)));
        return gameMap;
    }
}
