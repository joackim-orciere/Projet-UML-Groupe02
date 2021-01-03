package road;

import Tiles.Tile;
import Tiles.TileWithShift;
import player.Player;
import shifts.BikeShift;
import shifts.CarShift;
import shifts.WalkShift;

import static Misc.Misc.isInstance;


public class SideWalkTile extends TileWithShift {

    public SideWalkTile(){
        super( );
        ASCII = '#';

        double roll = Math.random();
        if( roll < 0.04 )
        {
            this.shift = new BikeShift();
        }
        else
            this.shift = null;
    }

    @Override
    public boolean accessible(Player player) {
        // TODO: conditions to enter the tile
        return (isInstance( player.getShift(), WalkShift.class)) ||
               (isInstance( player.getShift(), BikeShift.class));  // can enter cars if at foot
    }

    @Override
    public void enterTile(Player player) {
        // TODO: what happens when the player enter the tile
    }


}
