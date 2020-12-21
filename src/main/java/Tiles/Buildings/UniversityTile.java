package Tiles.Buildings;

import player.Player;

public class UniversityTile extends BuildingTile
{
    UniversityTile(int x, int y)
    {
        super(x, y);
        ASCII = 'U'; // set the ASCII value for the class
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