package main.utils;

import main.gameMap.GameMap;

public class GameSettings {
    private GameSettings() {

    }

    public static int calculateMaxAmountRabbits(GameMap gameMap) {
        double rabbitsDefaultPercent = ((gameMap.getRow() * gameMap.getColumn()) * 0.03);
        return (int) rabbitsDefaultPercent;
    }

    public static int calculateMaxAmountFoxes(GameMap gameMap) {
        double foxesDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) foxesDefaultPercent;
    }

    public static int calculateMaxAmountGrass(GameMap gameMap) {
        double grassDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.08;
        return (int) grassDefaultPercent;
    }
}
