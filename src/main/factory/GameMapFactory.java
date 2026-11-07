package main.factory;

import main.gameMap.GameMap;

public class GameMapFactory {
    public GameMap createGameMap(int row, int column) {
        return new GameMap(row, column);
    }

}
