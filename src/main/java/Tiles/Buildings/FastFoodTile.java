package Tiles.Buildings;

import player.Player;

public class FastFoodTile extends BuildingTile
{
    public FastFoodTile()
    {
        super();
        ASCII = 'F'; // set the ASCII value for the class
    }

    @Override
    public String enterTile(Player player)
    {
        player.changeSatiety(+25);
        player.changeSatiety(+10);
        player.changeMorale(+10);
        player.changeHealth(-5);
        return "You eat junk food: +25 satiety, +10 hydration, +10 morale, -5 health";
    }

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}