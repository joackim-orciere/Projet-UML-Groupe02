package Tiles;

import player.Player;

public class ForestTile extends Tile
{
    public ForestTile()
    {
        super();
        ASCII = 'A'; // set the ASCII value for the class
    }

    @Override
    public String getASCII() {
        return COLOR_GREEN + ASCII + "" + COLOR_DEFAULT;
    }

    @Override
    public String enterTile(Player player)
    {
        if( Math.random() < 0.10 )
        {
            player.changeHealth(-10 );
            return "You got sick from the forest: -10 health. ";
        }
        return "You contemplate the trees. ";
    }

    @Override
    public boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}
