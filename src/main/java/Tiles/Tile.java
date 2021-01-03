package Tiles;

import player.Player;
import shifts.Shift;

public abstract class Tile {
    protected char ASCII;

    public Tile() {

    }

    public char getASCII() {
            return ASCII;
    }

    public abstract void enterTile(Player player);
    public abstract boolean accessible( Player player );


}
