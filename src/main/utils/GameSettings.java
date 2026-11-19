package main.utils;

import main.gameMap.GameMap;

public class GameSettings {
    private GameSettings() {

    }

    public static int calculateMaxAmountRabbits(GameMap gameMap) {
        double rabbitsDefaultPercent = ((gameMap.getRow() * gameMap.getColumn()) * 0.03);
        return (int) rabbitsDefaultPercent;
    }
}
