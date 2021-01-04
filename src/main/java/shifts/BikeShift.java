package shifts;

import Tiles.Tile;
import player.Player;

public class BikeShift extends Shift{

    public BikeShift(){
        super();
        ASCII = '%';
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_RED + ASCII + Tile.COLOR_DEFAULT;
    }


    @Override
    public void changeStats(Player player) {
        player.changeHydration(-5);
        player.changeSatiety(-5);
    }



}
