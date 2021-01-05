package Tiles.Buildings;

import Player.Player;

public class UniversityTile extends BuildingTile
{
    public UniversityTile()
    {
        super();
        ASCII = 'U'; // set the ASCII value for the class
    }

    @Override
    public String enterTile(Player player)
    {
        // à chaque visite, le personnage à 30 % de chance d’obtenir un diplôme. Lorsqu’il en obtient un,
        // il a également un bonus de 5 points sur la barre de moral

        player.changeMorale( +5 );
        String s = "You enjoy the University campus: +5 morale. ";

        if( Math.random() < player.getDiplomaChance() )
        {
            player.changeNbrDiploma(+1);
            s += "\nYou graduated!: +1 Diploma";
        }

        return s;
    }

}