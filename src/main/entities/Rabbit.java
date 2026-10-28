package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Rabbit extends Herbivore{
    public Rabbit(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.RABBIT_EMOJI;
    }
}
