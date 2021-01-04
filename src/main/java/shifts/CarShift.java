package shifts;

import Tiles.Tile;
import player.Player;

public class CarShift extends Shift{

    public CarShift(){
        super();
        ASCII = '$';

    }

    @Override
    public String getASCII() {
        return Tile.COLOR_RED + ASCII + Tile.COLOR_DEFAULT;
    }

    @Override
    public void changeStats(Player player) {
        player.changeMorale(-2);
    }


}
