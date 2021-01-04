package Tiles;

import player.Player;

public class WaterTile extends Tile
{
    public WaterTile()
    {
        super();
        ASCII = '~'; // set the ASCII value for the class
    }

    @Override
    public String getASCII() {
        return COLOR_BLUE + ASCII + "" + COLOR_DEFAULT;
    }

    @Override
    public String enterTile(Player player)
    {
        return "You feel wet. ";
    }

    @Override
    public boolean accessible(Player player)
    {
        return player.getSwimsuit(); // return true if the player has a swimsuit
    }
}
