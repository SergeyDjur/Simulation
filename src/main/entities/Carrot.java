package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Carrot extends Entity {


    public Carrot(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.CARROT_EMOJI;
    }
}
