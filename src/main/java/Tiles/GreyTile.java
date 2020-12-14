package java.Tiles;

import java.Tiles.Player;
import java.Tiles.Tile;

public class GreyTile extends Tile {

    GreyTile(int x, int y) {
        super(x, y);
        ASCII = 'X'; // set the ASCII value for the class
    }

    @Override
    void enterTile(Player player) {
        // should never enter this function
    }

    @Override
    boolean accessible(Player player) {
        return false; // never accessible
    }

}
