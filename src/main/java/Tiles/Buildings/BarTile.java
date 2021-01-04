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
    public String enterTile(Player player)
    {

        player.changeMorale(+10 );
        player.changeHydration(+25 );
        player.changeHealth(-3 );

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

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}