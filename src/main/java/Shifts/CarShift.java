package Shifts;

import Tiles.Tile;
import Player.Player;

public class CarShift extends Shift{

    public CarShift(){
        super();
        ASCII = '$';

    }

    @Override
    public String getASCII() {
        return Tile.COLOR_RED + ASCII + Tile.COLOR_DEFAULT;
    }

}
