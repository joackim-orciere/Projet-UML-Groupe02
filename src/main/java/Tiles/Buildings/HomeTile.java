package Tiles.Buildings;

import player.Player;

public class HomeTile extends BuildingTile
{
    public HomeTile()
    {
        super();
        ASCII = 'H'; // set the ASCII value for the class
    }

    @Override
    public String enterTile(Player player)
    {
        player.changeMorale(+10);
        player.changeSatiety(+10);
        player.changeHydration(+10);
        return "Home Sweet Home!: +10 morale, satiety and hydration";
    }

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}
