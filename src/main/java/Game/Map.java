package Game;

import Tiles.*;
import Tiles.Buildings.*;
import player.Player;
import road.*;
import shifts.BikeShift;
import shifts.CarShift;

import static Misc.Misc.isInstance;


public class Map {
    private final int n;
    private final int m;

    private boolean placed_home = false;

    // probabilities
    static double pB; // Bar
    static double pF; // FastFood
    static double pL; // Library
    static double pU; // University

    static double pPool = 0.12;
    static double pPark = 0.123;

    public int homeX;    // used to initialize the player at the corresponding position
    public int homeY;

    Tile[][] tiles;

    public Map(int n, int m) {
        this.n = n;
        this.m = m;
        tiles = new Tile[n][m];   // array containing the Tiles of the map
        generateMap();

    }

    public void generateMap() // TODO proper map generation
    {
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                tiles[x][y] = new GreyTile();
            }
        }

        // a neighbour is a square of 7 x 5, 9 x 7 counting the sidewalks and roads
        //
        //  .........
        //  .#######.
        //  .#H   U#.
        //  .#     #.
        //  .#  B  #.
        //  .#######.
        //  .........

        int nx = (int) Math.ceil(n / 9.0); // divide by 8
        int ny = (int) Math.ceil(m / 7.0); // divide by 6

        pB = 6.0 / (nx * ny);
        pU = pB;
        pL = pB;
        pF = pB;

        for (int y = 0; y < ny; y++) {
            for (int x = 0; x < nx; x++) {
                int cx = x * 9;
                int cy = y * 7;


                if( placed_home ) System.out.println("HOME");
                else
                    System.out.println("NOT YET");

                if (x == nx - 1 && y == ny - 1)
                {
                    generateBuildingNeighbour(cx, cy, true);
                }
                else {
                    boolean empty = generateBuildingNeighbour(cx, cy, false);
                    if (empty && placed_home) {
                        if (Math.random() < pPool ) {
                            generatePoolNeighbour(cx, cy);
                            pPool = 0;
                        } else if (Math.random() < pPark ) {
                            generateSmallParkNeighbour(cx, cy);
                            pPark = 0;
                        } else if (Math.random() < 0.5 )
                            generateThingNeighbour(cx, cy);
                    }
                }
                pPark = pPark * 2;
                pPool = pPool * 2;
            }
        }
    }

    public String getASCII(Player player) {
        String s = "";
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (x == player.getX() && y == player.getY())
                    s += player.getASCII();
                else
                    s += tiles[x][y].getASCII();
            }
            s += '\n';
        }
        return s;
    }


    public boolean generateBuildingNeighbour(int x, int y, boolean last) {
        setRect(x, y, x + 9, y + 7, RoadTile.class);
        setRect(x + 1, y + 1, x + 8, y + 6, SideWalkTile.class);
        setRect(x + 2, y + 2, x + 7, y + 5, GreyTile.class);

        generateCrossings(x, y);

        double roll;

        boolean empty = true;

        if (last) {
            if (pB != 0) setTile(x + 3, y + 2, BarTile.class);
            if (pF != 0) setTile(x + 4, y + 4, FastFoodTile.class);
            if (pL != 0) setTile(x + 2, y + 3, LibraryTile.class);
            if (pU != 0) setTile(x + 6, y + 3, UniversityTile.class);
            empty = false;
        }
        if (!placed_home) {
            setTile(x + 6, y + 4, HomeTile.class);
            homeX = x + 6;
            homeY = y + 4;
            placed_home = true;
            empty = false;

            // connect every time
            setTile(x + 8, y + 3, CrossingTile.class);
            setTile(x + 9, y + 3, CrossingTile.class);
            setTile(x + 4, y + 6, CrossingTile.class);
            setTile(x + 4, y + 7, CrossingTile.class);

             /*
             // Always spawn a Car and a Bike near Home

            RoadTile roadWithCar = new RoadTile();
            roadWithCar.shift = new CarShift();

            SideWalkTile sideWalkwithBike = new SideWalkTile();
            sideWalkwithBike.shift = new BikeShift();

            tiles[x + 5][y + 5] = sideWalkwithBike;
            tiles[x + 2][y + 6] = roadWithCar;

             */

        }
        if (Math.random() < pB / (pB + pF + pL + pU + 0.001)) // bar
        {
            roll = Math.random();
            if (roll < pB || last) {
                pB = 0;
                setTile(x + 3, y + 2, BarTile.class);
                empty = false;
            } else {
                pB = pB * 2.0;
                if (pB > 1) pB = 1;
            }
        }
        else if (Math.random() < pF / (pF + pB + pL + pU + 0.001)) // fastfood
        {
            roll = Math.random();
            if (roll < pF || last) {
                pF = 0;
                setTile(x + 4, y + 4, FastFoodTile.class);
                empty = false;
            } else {
                pF = pF * 2.0;
                if (pF > 1) pF = 1;
            }
        }
        else if (Math.random() < pL / (pL + pF + pB + pU + 0.001)) // library
        {
            roll = Math.random();
            if (roll < pL || last) {
                pL = 0;
                setTile(x + 2, y + 3, LibraryTile.class);
                empty = false;
            } else {
                pL = pL * 2.0;
                if (pL > 1) pL = 1;
            }

        }
        else if (Math.random() < pU / (pU + pF + pL + pB + 0.001))// university
        {
            roll = Math.random();
            if (roll < pU) {
                pU = 0;
                setTile(x + 6, y + 3, UniversityTile.class);
                empty = false;
            } else {
                pU = pU * 2.0;
                if (pU > 1) pU = 1;
            }
        }

        return empty;
    }


    public void generateCrossings(int x, int y) {
        double threshold = 0.4;
        if (Math.random() < threshold ) {
            setTile(x + 0, y + 3, CrossingTile.class);
            setTile(x - 1, y + 3, CrossingTile.class);
        }
        if (Math.random() < threshold ) {
            setTile(x + 8, y + 3, CrossingTile.class);
            setTile(x + 9, y + 3, CrossingTile.class);
        }
        if (Math.random() < threshold ) {
            setTile(x + 4, y + 0, CrossingTile.class);
            setTile(x + 4, y - 1, CrossingTile.class);
        }
        if (Math.random() < threshold ) {
            setTile(x + 4, y + 6, CrossingTile.class);
            setTile(x + 4, y + 7, CrossingTile.class);
        }
    }

    public void generateBigParkNeighbour(int x, int y) {
        setRect(x, y, x + 9, y + 7, RoadTile.class);
        setRect(x + 1, y + 1, x + 8, y + 6, SideWalkTile.class);
        setRect(x + 2, y + 2, x + 7, y + 5, ForestTile.class);

        generateCrossings(x, y);
    }

    public void generateThingNeighbour(int x, int y) {
        setRect(x, y, x + 9, y + 7, RoadTile.class);
        setRect(x + 1, y + 1, x + 8, y + 6, SideWalkTile.class);
        setRect(x + 2, y + 2, x + 7, y + 5, WaterTile.class);
        setTile(x + 2, y + 2, ForestTile.class);
        setTile(x + 6, y + 4, ForestTile.class);
        setTile(x + 6, y + 4, ForestTile.class);
        setTile(x + 3, y + 2, ForestTile.class);
        setTile(x + 3, y + 3, ForestTile.class);
        setTile(x + 2, y + 3, ForestTile.class);
        setTile(x + 4, y + 2, ForestTile.class);

        generateCrossings(x, y);

    }

    public void generateSmallParkNeighbour(int x, int y) {
        setRect(x, y, x + 9, y + 7, RoadTile.class);
        setRect(x + 1, y + 1, x + 8, y + 6, SideWalkTile.class);
        setRect(x + 2, y + 2, x + 7, y + 5, ForestTile.class);

        generateCrossings(x, y);
    }

    public void generatePoolNeighbour(int x, int y) {
        setRect(x, y, x + 9, y + 7, RoadTile.class);
        setRect(x + 1, y + 1, x + 8, y + 6, SideWalkTile.class);
        setRect(x + 2, y + 2, x + 7, y + 5, WaterTile.class);

        generateCrossings(x, y);
    }

    // set a whole rectangle
    public void setRect(int x1, int y1, int x2, int y2, Class c) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        for (int x = 0; x < dx; x++) {
            for (int y = 0; y < dy; y++) {
                setTile(x1 + x, y1 + y, c);
            }
        }
    }

    public void setTile(int x, int y, Class c) {

        Tile obj = new WaterTile();
        try {
            obj = (Tile) c.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Tile decoy = new WaterTile();
        if (x >= n || x < 0 || y >= m || y < 0) // outside
            return;
        else if ( isInstance(tiles[x][y], CrossingTile.class) )
            return;
        else
        tiles[x][y] = obj;
    }

    public Tile getTile(int x, int y) {
        // decoy object to be returned if out of bond
        Tile decoy = new WaterTile();
        if (x >= n || x < 0 || y >= m || y < 0)
            return decoy;
        else
            return tiles[x][y];
    }


}
