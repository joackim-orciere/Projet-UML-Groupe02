package Road;

import Tiles.TileWithShift;
import Player.Player;
import Shifts.BikeShift;
import Shifts.WalkShift;
import Traps.*;

import static Misc.Misc.isInstance;


public class SideWalkTile extends TileWithShift {

    Trap trap = null;

    public SideWalkTile(){
        super( );
        ASCII = '#';

        if( Math.random() < 0.05 )
        {
            this.shift = new BikeShift();
        }
        else
            this.shift = null;

        if( Math.random() < 0.05 )
        {
            double roll = Math.random();
            if( roll < 0.33 )
                trap = new BananaPeelTrap();
            else if( roll < 0.66 )
                trap = new StrollerTrap();
            else
                trap = new DogPoopTrap();
        }
    }

    @Override
    public boolean accessible(Player player) {
        // TODO: conditions to enter the tile
        return (isInstance( player.getShift(), WalkShift.class)) ||
               (isInstance( player.getShift(), BikeShift.class));  // can enter cars if at foot
    }

    @Override
    public String enterTile(Player player) {
        if (trap != null)
            return trap.activateTrap(player);
        return "";
    }
}
