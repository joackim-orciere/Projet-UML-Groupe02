package java.Tiles;


import Tiles.Tile;
import player.Player;

public class GreyTile extends Tile {

    GreyTile(int x, int y) {
        super(x, y);
        ASCII = 'X'; // set the ASCII value for the class
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
