package Tiles.Buildings;

import Player.Player;

public class LibraryTile extends BuildingTile
{
    public LibraryTile()
    {
        super();
        ASCII = 'L'; // set the ASCII value for the class
    }

    @Override
    public String enterTile(Player player)
    {
        // 20 points de moral.
        // livre sur le génie logiciel (5 %),
        // 10 % sur la possibilité d’obtenir son diplôme.

        player.changeMorale(+20);
        String s = "You enjoy the silence: +20 morale. ";

        if( Math.random() < 0.05 )
        {
            player.changeMorale(+20);
            player.changeDiplomaChance(+0.1);
            s += "\nYou found a Software Engineering book: +20 morale, +10% chance to graduate";
        }

        return s;
    }

}

