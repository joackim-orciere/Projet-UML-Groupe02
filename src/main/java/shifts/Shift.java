package shifts;

import Tiles.Tile;
import player.Player;

public abstract class Shift {

    protected char ASCII;

    public abstract void changeStats(Player player);

    public String getASCII() {
        return ASCII + "";
    }

    public String getPlayerASCII()
    {
        return Tile.COLOR_YELLOW + ASCII + Tile.COLOR_DEFAULT;
    }



}
