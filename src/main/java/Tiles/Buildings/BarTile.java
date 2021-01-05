package Tiles.Buildings;

import Player.Hippie;
import Player.Player;

import static Misc.Misc.isInstance;

public class BarTile extends BuildingTile
{
    public BarTile()
    {
        super();
        ASCII = 'B'; // set the ASCII value for the class
    }

    @Override
    public String enterTile(Player player)
    {
        int coef = 1;
        if( isInstance( player, Hippie.class ))
        {
            coef = 2;
        }

        player.changeMorale(+10 );
        player.changeHydration(+25 );
        player.changeHealth(-3 / coef );

        String s = "You drink a lot: +25 hydration, +10 moral, -3 health. ";

        if( Math.random() < 0.25 && !player.getSwimsuit()) // Swimsuit
        {
            player.setSwimsuit( true );
            s += "\nYou also found an old Swimsuit. ";
        }
        if( Math.random() < 0.05 ) // sujet
        {
            player.changeDiplomaChance(+0.05 );
            s += "\nYou found the topic of the next exam: +5% chance to graduate.";
        }

        return s;
    }

}