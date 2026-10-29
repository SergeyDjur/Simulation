package main.simulation;

import main.actions.InitActions;
import main.actions.TurnActions;
import main.entityUtils.EntityEmoji;
import main.entityUtils.EntityFactory;
import main.entityUtils.EntityRenderer;
import main.gameMap.GameMap;
import main.gameMap.GameMapFactory;
import main.gameMap.GameMapRenderer;

public class Simulation {
    // 1st init action
    //2nd turn action
    //start simulation - method starts endless game loop
    //pause simulation  - method make simulation on pause

    public static void main(String[] args) {
        GameMapFactory gameMapFactory = new GameMapFactory();
        GameMap gameMap = gameMapFactory.createGameMap(10, 15);
        EntityFactory entityFactory = new EntityFactory();
        InitActions initAction = new InitActions(entityFactory);

        initAction.prepareGame(gameMap);
        Simulation simulation = new Simulation();
        EntityEmoji entityEmoji = new EntityEmoji();
        EntityRenderer entityRenderer = new EntityRenderer(entityEmoji);
        TurnActions turnAction = new TurnActions();
        turnAction.makeTurn(gameMap);
        GameMapRenderer gameMapRenderer = new GameMapRenderer(entityRenderer);
        gameMapRenderer.render(gameMap, entityEmoji);

    }


}
