package Game;

import java.Tiles.Tile;
import java.Tiles.WaterTile;

public class Map
{
    private int n;
    private int m;
    private int size = n * m;

    Tile[][] tiles = new Tile[n][m];   // array containing the Tiles of the map

    public Map( int n, int m )
    {
        this.n = n;
        this.m = m;
    }

    public void generateMap( )
    {
        for( int x = 0; x < n; x++ )
        {
            for( int y = 0; y < m; y++ )
            {
                tiles[x][y] = new WaterTile(x,y);
            }
        }
    }

    public String getASCII( )
    {
        String s ="";
        for( int x = 0; x < n; x++ )
        {
            for( int y = 0; y < m; y++ )
            {
                s += tiles[x][y].getASCII();
            }
            s += '\n';
        }
        return s;
    }
}
