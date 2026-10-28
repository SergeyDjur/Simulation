package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Grass extends Entity{
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.GRASS_EMOJI;
    }
}
