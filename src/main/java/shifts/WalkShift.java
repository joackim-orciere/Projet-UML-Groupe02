package shifts;

import Tiles.Tile;
import player.Player;

public class WalkShift extends Shift {

    public WalkShift() {
        ASCII= '&';
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_YELLOW + ASCII + Tile.COLOR_DEFAULT;
    }



    public void changeStats(Player player) {
        player.changeHydration(-10);
        player.changeSatiety(-10);
    }
}
