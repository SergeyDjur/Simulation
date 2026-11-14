package main.utils;

import main.Coordinates;
import main.entity.Entity;
import main.gameMap.GameMap;

import java.util.*;

public class BFSPathFinder {
    private BFSPathFinder() {

    }

    private static List<Coordinates> getNeighbours(GameMap gameMap, Coordinates exploringCell) {
        List<Coordinates> neighbours = new ArrayList<>();

        Coordinates rightNeighbour = new Coordinates(exploringCell.row(), exploringCell.column() + 1);
        if (GameMapUtils.isInsideMap(gameMap, rightNeighbour)) {
            neighbours.add(rightNeighbour);
        }

        Coordinates leftNeighbour = new Coordinates(exploringCell.row(), exploringCell.column() - 1);
        if (GameMapUtils.isInsideMap(gameMap, leftNeighbour)) {
            neighbours.add(leftNeighbour);
        }

        Coordinates upNeighbour = new Coordinates(exploringCell.row() + 1, exploringCell.column());
        if (GameMapUtils.isInsideMap(gameMap, upNeighbour)) {
            neighbours.add(upNeighbour);
        }

        Coordinates downNeighbour = new Coordinates(exploringCell.row() - 1, exploringCell.column());
        if (GameMapUtils.isInsideMap(gameMap, downNeighbour)) {
            neighbours.add(downNeighbour);
        }

        Coordinates upLeftNeighbour = new Coordinates(exploringCell.row() + 1, exploringCell.column() - 1);
        if (GameMapUtils.isInsideMap(gameMap, upNeighbour)) {
            neighbours.add(upLeftNeighbour);
        }

        Coordinates upRightNeighbour = new Coordinates(exploringCell.row() + 1, exploringCell.column() + 1);
        if (GameMapUtils.isInsideMap(gameMap, upRightNeighbour)) {
            neighbours.add(upRightNeighbour);
        }

        Coordinates downRightNeighbour = new Coordinates(exploringCell.row() - 1, exploringCell.column() + 1);
        if (GameMapUtils.isInsideMap(gameMap, downRightNeighbour)) {
            neighbours.add(downRightNeighbour);
        }

        Coordinates downLeftNeighbour = new Coordinates(exploringCell.row() - 1, exploringCell.column() - 1);
        if (GameMapUtils.isInsideMap(gameMap, downLeftNeighbour)) {
            neighbours.add(downLeftNeighbour);
        }

        return neighbours;

    }

    private static List<Coordinates> rebuildPath(Map<Coordinates, Coordinates> kidParent, Coordinates start, Coordinates target) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = target;
        while (current != null && !current.equals(start)) {
            path.add(current);
            current = kidParent.get(current);

        }
        path.add(start);
        Collections.reverse(path);
        return new ArrayList<>(path);


    }



    public static List<Coordinates> findPath(GameMap gameMap, Coordinates currentPosition, Class<? extends Entity> targetEntity) {

        Queue<Coordinates> exploringCells = new ArrayDeque<>();
        Set<Coordinates> exploredCells = new HashSet<>();

        Map<Coordinates, Coordinates> kidParent = new HashMap<>();

        exploringCells.add(currentPosition);
        exploredCells.add(currentPosition);

        while (!exploringCells.isEmpty()) {
            Coordinates exploringCell = exploringCells.poll();
            Entity exploringEntity = gameMap.getEntityAtCoordinate(exploringCell);
            if (targetEntity.isInstance(exploringEntity)) {
                return rebuildPath(kidParent, currentPosition, exploringCell);
            }
            List<Coordinates> neighbours = getNeighbours(gameMap, exploringCell);
            for (Coordinates neighbour : neighbours) {
                if (exploredCells.contains(neighbour)) {
                    continue;
                }
                Entity neighbourEntity = gameMap.getEntityAtCoordinate(neighbour);
                if (neighbourEntity != null && !targetEntity.isInstance(neighbourEntity)) {
                    continue;
                }
                kidParent.put(neighbour, exploringCell);
                exploringCells.add(neighbour);
                exploredCells.add(neighbour);
            }

        }
        return List.of();


    }


}
