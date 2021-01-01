package Game;

import Tiles.*;
import Tiles.Buildings.*;
import road.*;


public class Map
{
    private int n;
    private int m;
    private int size = n * m;

    static boolean home = true;

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
                tiles[x][y] = new RoadTile();
            }
        }

        // a neighbour is a square of 6 x 4, 8 x 6 counting the sidewalks and roads
        //
        //  ........
        //  .######.
        //  .#H  U#.
        //  .#  B #.
        //  .######.
        //  ........

        int nx = (int) Math.floor(n / 8); // divide by 8
        int ny = (int) Math.floor(m / 6); // divide by 6

        for( int y = 0; y < ny; y++ )
        {
            for( int x = 0; x < nx; x++ )
            {
                int cx = x * 9;
                int cy = y * 7;
                generateBuildingNeighbours(cx, cy );

                if( x == 2 && y == 1 )
                    generatePoolNeighbours(cx, cy);

                if( x == 6 && y == 0 )
                    generateSmallParkNeighbours(cx, cy);
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

        setRect( x+1,y+1, x+8, y+6, new SideWalkTile());
        setRect( x+2,y+2, x+7, y+5, new GreyTile());

        if( home )
        {
            setTile(x + 6, y + 4, new HomeTile());
            home = false;
        }
        if(Math.random() < 0.20) setTile(x + 2, y + 2, new LibraryTile());
        if(Math.random() < 0.20) setTile(x + 4, y + 2, new UniversityTile());
        if(Math.random() < 0.20) setTile(x + 2, y + 4, new FastFoodTile());
        if(Math.random() < 0.20) setTile(x + 6, y + 3, new LibraryTile());
        if(Math.random() < 0.20) setTile(x + 3, y + 4, new BarTile());
    }

    public void generateBigParkNeighbours( int x, int y )
    {
        setRect( x-8,y-6, x+8, y+6, new SideWalkTile());
        setRect( x-7,y-5, x+7, y+5, new ForestTile());
    }

    public void generateSmallParkNeighbours( int x, int y )
    {
        setRect( x-8,y+1, x+8, y+6, new SideWalkTile());
        setRect( x-7,y+2, x+7, y+5, new ForestTile());
    }

    public void generatePoolNeighbours( int x, int y )
    {
        setRect( x+1,y+1, x+8, y+6, new SideWalkTile());
        setRect( x+2,y+2, x+7, y+5, new WaterTile());
    }

    // set a whole rectangle
    public void setRect( int x1, int y1, int x2, int y2, Tile tile)
    {
        int dx = x2 - x1;
        int dy = y2 - y1;

        for( int x=0; x < dx; x++)
        {
            for( int y=0; y < dy; y++)
            {
                setTile(x1 + x, y1 + y, tile);
            }
        }
    }

    public void setTile(int x, int y, Tile tile)
    {
        Tile decoy = new WaterTile();
        if( x >= n || x < 0 || y >= m || y < 0 )
            return;
        else
            tiles[x][y] = tile;
    }

    public Tile getTile(int x, int y)
    {
        // decoy object to be returned if out of bond
        Tile decoy = new WaterTile();
        if( x >= n || x < 0 || y >= m || y < 0 )
            return decoy;
        else
            return tiles[x][y];
    }
}
