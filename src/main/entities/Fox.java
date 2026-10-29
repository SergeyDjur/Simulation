package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Fox extends Predator {
    public Fox(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Coordinates makeMove(Coordinates currentPosition) {
        Coordinates targetPosition = new Coordinates(7, 10);
        return targetPosition;
    }


    @Override
    public String getEmoji() {
        return EntityEmoji.FOX_EMOJI;
    }


}
