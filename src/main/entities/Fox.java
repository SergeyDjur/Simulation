package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Fox extends Predator{
    public Fox(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.FOX_EMOJI;
    }


}
