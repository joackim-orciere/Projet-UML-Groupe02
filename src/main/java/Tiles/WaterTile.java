package Tiles;

import player.Player;

public class WaterTile extends Tile
{
    public WaterTile(int x, int y)
    {
        super(x, y);
        ASCII = '~'; // set the ASCII value for the class
    }

    @Override
    public void enterTile(Player player)
    {
        // TODO: what happens when the player enter the tile
    }

    @Override
    public boolean accessible(Player player)
    {
        return player.getSwimsuit(); // return true if the player has a swimsuit
    }
}
