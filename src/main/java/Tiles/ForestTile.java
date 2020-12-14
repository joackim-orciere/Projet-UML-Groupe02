package java.Tiles;

public class ForestTile extends Tile
{
    ForestTile(int x, int y)
    {
        super(x, y);
        ASCII = 'A'; // set the ASCII value for the class
    }

    @Override
    void enterTile(Player player)
    {
        // TODO: what happens when the player enter the tile
    }

    @Override
    boolean accessible(Player player)
    {
        // TODO: conditions to enter the tile
        return true;
    }
}
