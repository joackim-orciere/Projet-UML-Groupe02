package Tiles.Buildings;

import player.Hippie;
import player.Player;

import static Misc.Misc.isInstance;

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
        int coef = 1;
        if( isInstance( player, Hippie.class ))
        {
            coef = 2;
        }

        player.changeSatiety(+25);
        player.changeSatiety(+10);
        player.changeMorale(+10);
        player.changeHealth(-5 / coef );
        return "You eat junk food: +25 satiety, +10 hydration, +10 morale, -5 health";
    }

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}