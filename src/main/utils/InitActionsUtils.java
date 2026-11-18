package main.utils;

import main.gameMap.GameMap;

public class InitActionsUtils {
    private InitActionsUtils() {

    }



    public static int calculateDefaultPercentFoxes(GameMap gameMap) {
        double foxesDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) foxesDefaultPercent;
    }

    public static int calculateDefaultPercentGrass(GameMap gameMap) {
        double grassDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.08;
        return (int) grassDefaultPercent;
    }

    public static int calculateDefaultPercentRocks(GameMap gameMap) {
        double rocksDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) rocksDefaultPercent;
    }

    public static int calculateDefaultPercentTrees(GameMap gameMap) {
        double treesDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) treesDefaultPercent;
    }
}
