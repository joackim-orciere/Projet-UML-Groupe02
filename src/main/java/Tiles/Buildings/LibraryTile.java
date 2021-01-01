package Tiles.Buildings;

import player.Player;

public class LibraryTile extends BuildingTile
{
    public LibraryTile()
    {
        super();
        ASCII = 'L'; // set the ASCII value for the class
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

