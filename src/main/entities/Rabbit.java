package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Rabbit extends Herbivore {
    public Rabbit(Coordinates coordinates) {
        super(coordinates);
    }

    /*
    now current coordinates are hardcoded in makeMove method for testing entities
    movements by changing the values of target coordinates
     */
    @Override
    public Coordinates makeMove(Coordinates currentPosition) {
        Coordinates targetPosition = new Coordinates(4, 3);
        return targetPosition;
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.RABBIT_EMOJI;
    }
}
