package Game;

import Tiles.*;


public class Map
{
    private int n;
    private int m;
    private int size = n * m;

    Tile[][] tiles;

    public Map( int n, int m )
    {
        this.n = n;
        this.m = m;
        tiles = new Tile[n][m];   // array containing the Tiles of the map
        generateMap();
    }

    public void generateMap( ) // TODO proper map generation
    {
        for( int y = 0; y < m; y++ )
        {
            for( int x = 0; x < n; x++ )
            {
                tiles[x][y] = new WaterTile(x,y);
            }
        }

        // a neighbour is a square of 8 x 4
        //
        //  ........
        //  .######.
        //  .#H  U#.
        //  .#  B #.
        //  .######.
        //  ........

        int nx = (int) Math.floor(n >> 3); // divide by 8
        int ny = (int) Math.floor(m >> 2); // divide by 4

        for( int y = 0; y < ny; y++ )
        {
            for( int x = 0; x < nx; x++ )
            {
                int cx = x * 8;
                int cy = y * 4;
                System.out.println("(" + cx + ", " + cy + ")");
                tiles[cx][cy] = new ForestTile(x*8,y*4);
            }
        }
    }

    public String getASCII( )
    {
        String s ="";
        for( int y = 0; y < m; y++ )
        {
            for( int x = 0; x < n; x++ )
            {
                s += tiles[x][y].getASCII();
            }
            s += '\n';
        }
        return s;
    }

    public void generateBuildingNeighbours( int x, int y )
    {
        // TODO
    }

    public void generateParkNeighbours( int x, int y )
    {
        // TODO
    }
}
