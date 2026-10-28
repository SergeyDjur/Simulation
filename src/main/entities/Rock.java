package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Rock extends Entity{
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.ROCK_EMOJI;
    }
}
