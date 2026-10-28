package main.gameMap;

public class GameMapFactory {
    public GameMap createGameMap(int row, int column) {
        return new GameMap(row, column);
    }
}
