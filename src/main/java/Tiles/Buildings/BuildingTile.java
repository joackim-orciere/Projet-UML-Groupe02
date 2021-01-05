package Tiles.Buildings;

import Tiles.Tile;
import Player.Player;
import Shifts.BikeShift;
import Shifts.CarShift;

import static Misc.Misc.isInstance;

public abstract class BuildingTile extends Tile
{
    String name;
    BuildingTile()
    {
        super();
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_PURPLE + ASCII + Tile.COLOR_DEFAULT;
    }

    @Override
    public boolean accessible(Player player)
    {
        if( isInstance( player.getShift(), CarShift.class  ) ||
            isInstance( player.getShift(), BikeShift.class ))
        {
            return false; // cannot enter buildings with a car nor a bike
        }
        return true;
    }
}
