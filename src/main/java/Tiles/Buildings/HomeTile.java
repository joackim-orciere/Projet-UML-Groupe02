package java.Tiles.Buildings;

import java.Tiles.Player;

public class HomeTile extends BuildingTile
{
    HomeTile(int x, int y)
    {
        super(x, y);
        ASCII = 'H'; // set the ASCII value for the class
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
