package Tiles;

import player.Player;

public class GreyTile extends Tile {

    public GreyTile()
    {
        super();
        ASCII = ' '; // set the ASCII value for the class
    }

    @Override
    public void enterTile(Player player) {
        // should never enter this function
    }

    @Override
    public boolean accessible(Player player) {
        return false; // never accessible
    }

}
