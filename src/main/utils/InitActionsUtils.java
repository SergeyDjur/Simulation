package main.utils;

import main.gameMap.GameMap;

public class InitActionsUtils {
    private InitActionsUtils() {

    }



    public static int calculateDefaultPercentRocks(GameMap gameMap) {
        double rocksDefaultPercent = (gameMap.getRow() * gameMap.getColumn()) * 0.01;
        return (int) rocksDefaultPercent;
    }


}
