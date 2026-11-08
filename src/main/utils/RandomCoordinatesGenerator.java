package main.utils;

import main.Coordinates;
import main.entity.Entity;
import main.factory.EntityFactory;
import main.factory.GameMapFactory;
import main.gameMap.GameMap;
import main.renderer.EntityRenderer;
import main.renderer.GameMapConsoleRenderer;

import java.util.Random;

public class RandomCoordinatesGenerator {
    private RandomCoordinatesGenerator() {

    }

    private static final Random random = new Random();

    public static Coordinates generate(GameMap gameMap) {
        int rowPosition = random.nextInt(gameMap.getRow());
        int columnPosition = random.nextInt(gameMap.getColumn());
        return new Coordinates(rowPosition, columnPosition);

    }

    public static void main(String[] args) {
        GameMapFactory gameMapFactory = new GameMapFactory();
        GameMap gameMap = gameMapFactory.createGameMap(10, 10);
        Coordinates foxCord = generate(gameMap);
        EntityFactory entityFactory = new EntityFactory();
        Entity fox = entityFactory.createEntity(EntityType.FOX, foxCord);
        Coordinates rabbitCord = generate(gameMap);
        Entity rabbit = entityFactory.createEntity(EntityType.RABBIT, rabbitCord);
        gameMap.setUpEntity(gameMap, foxCord, fox);
        gameMap.setUpEntity(gameMap, rabbitCord, rabbit);
        Coordinates grassCord = generate(gameMap);
        Entity grass = entityFactory.createEntity(EntityType.GRASS, grassCord);
        gameMap.setUpEntity(gameMap, grassCord, grass);
        GameMapConsoleRenderer renderer = new GameMapConsoleRenderer();
        EntityRenderer entityRenderer = new EntityRenderer();
        renderer.render(gameMap, entityRenderer);
    }
}
