package Shifts;

import Tiles.Tile;
import Player.Player;

public class BikeShift extends Shift{

    public BikeShift(){
        super();
        ASCII = '%';
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_RED + ASCII + Tile.COLOR_DEFAULT;
    }


}