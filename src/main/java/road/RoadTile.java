package road;

import Tiles.TileWithShift;
import player.Player;
import shifts.*;

import static Misc.Misc.isInstance;

public class RoadTile extends TileWithShift {

    public RoadTile( )
    {
        super( );
        ASCII = '.';

        double roll = Math.random();
        if( roll < 0.032 )
        {
            this.shift = new CarShift();
        }
        else
            this.shift = null;
    }



    @Override
    public boolean accessible(Player player) {
        return (isInstance( player.getShift(), CarShift.class)  && shift == null) ||    // can't drive on top of other cars or bikes
               (isInstance( player.getShift(), BikeShift.class)) ||                     // can ride on top of other shifts
               (isInstance( player.getShift(), WalkShift.class) && shift != null) ;     // can enter cars if at foot
    }

    @Override
    public String enterTile(Player player)
    {
        return "";
    }
}
