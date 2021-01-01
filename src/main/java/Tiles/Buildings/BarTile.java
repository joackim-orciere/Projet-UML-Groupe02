package Tiles.Buildings;

import player.Player;

public class BarTile extends BuildingTile
{
    public BarTile()
    {
        super();
        ASCII = 'B'; // set the ASCII value for the class
    }

    @Override
    public void enterTile(Player player)
    {
        // TODO: what happens when the player enter the tile
    }

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}