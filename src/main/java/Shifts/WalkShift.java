package Shifts;

import Tiles.Tile;
import Player.Player;

public class WalkShift extends Shift {

    public WalkShift() {
        ASCII = '&';
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_YELLOW + ASCII + Tile.COLOR_DEFAULT;
    }

}
