package main.entities;

import main.Coordinates;
import main.entityUtils.EntityEmoji;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return EntityEmoji.TREE_EMOJI;
    }
}
