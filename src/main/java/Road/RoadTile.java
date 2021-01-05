package Road;

import Tiles.TileWithShift;
import Player.Hippie;
import Player.Player;
import Shifts.*;
import Traps.PoliceTrap;
import Traps.PotholeTrap;
import Traps.RedLightTrap;
import Traps.Trap;

import static Misc.Misc.isInstance;

public class RoadTile extends TileWithShift {

    Trap trap = null;

    public RoadTile( )
    {
        super( );
        ASCII = '.';

        if( Math.random() < 0.05 )
        {
            this.shift = new CarShift();
        }
        else
            this.shift = null;

        if( Math.random() < 0.05 )
        {
            double roll = Math.random();
            if( roll < 0.33 )
                trap = new PoliceTrap();
            else if( roll < 0.66 )
                trap = new PotholeTrap();
            else
                trap = new RedLightTrap();
        }
    }



    @Override
    public boolean accessible(Player player) {
        return (isInstance( player.getShift(), CarShift.class)  && shift == null) ||    // can't drive on top of other cars or bikes
               (isInstance( player.getShift(), BikeShift.class)) ||                     // can ride on top of other shifts
               (isInstance( player.getShift(), WalkShift.class) && shift != null && !isInstance(player, Hippie.class)) ;     // can enter cars if at foot
    }

    @Override
    public String enterTile(Player player)
    {
        if( trap != null )
            return trap.activateTrap(player);
        return "";
    }
}
