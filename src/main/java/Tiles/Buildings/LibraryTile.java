package java.Tiles.Buildings;

import java.Tiles.Player;

public class LibraryTile extends BuildingTile
{
    LibraryTile(int x, int y)
    {
        super(x, y);
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

