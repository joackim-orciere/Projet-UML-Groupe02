package Game;

import Tiles.Tile;
import Tiles.TileWithShift;
import player.*;
import shifts.*;

import java.io.IOException;
import java.util.Scanner;

import static Misc.Misc.isInstance;

public class Game
{
    private Map map;
    private Player player;

    static int playerType;
    static int mapType;
    static String playerName;


    public void init()
    {
        switch (mapType) {
            case 1:
                map = new Map(27, 14);
                break;
            case 2:
                map = new Map(35, 14);
                break;
            case 3:
                map = new Map(45, 14);
                break;
        }

        switch (playerType) {
            case 1:
                player = new Standard(map.homeX, map.homeY, playerName);
                break;
            case 2:
                player = new Hippie(map.homeX, map.homeY, playerName);
                break;
            case 3:
                player = new HommePresse(map.homeX, map.homeY, playerName);
                break;
        }


    }

    public void start()
    {
        // TODO game loop
    }

    public void promptStartOptions()
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Choisissez votre personnage: \n1: Standard \n2: Hippie \n3: Homme pressé \n -> " );
        playerType = scanner.nextInt();

        if( playerType < 1 || playerType > 3 )
        {
            System.out.println("Erreur, default: Standard");
            playerType = 1;
        }

        System.out.print("Choisissez votre nom: \n -> ");
        String playerName = scanner.next();

        System.out.print("Choisissez la taille de la carte: \n1: petite \n2: moyenne \n3: grande \n -> ");
        mapType = scanner.nextInt();

        if( mapType < 1 || mapType > 3 )
        {
            System.out.println("Erreur, default: petite");
            mapType = 1;
        }

        System.out.print("Commencer la partie ? [play/quit]: \n -> ");
        String s = scanner.next();

        if( s.equals("quit") )
        {
            System.out.println("Exiting game..");
            System.exit(0);
        }


        System.out.print("\033[H\033[2J"); // clear screen
    }

    public String getASCII()
    {
        return map.getASCII( player );
    }

    public void promptChoice()
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("z: Up, s: Down, q: Left, d: right");

        boolean isDriving = isInstance( player.getShift(), CarShift.class);
        boolean isRiding = isInstance( player.getShift(), BikeShift.class);
        boolean isOnTopOfBike = false;
        boolean isOnTopOfCar = false;

        Tile current_tile = map.getTile(player.getX(), player.getY());
        if( isInstance( current_tile, TileWithShift.class) )
        {
            TileWithShift tileWithShift = ( TileWithShift ) current_tile;
            isOnTopOfBike = isInstance( tileWithShift.shift, BikeShift.class );
            isOnTopOfCar  = isInstance( tileWithShift.shift,  CarShift.class );
        }


        if( isDriving )
            System.out.println("l: leave car");

        else if( isOnTopOfCar )
            System.out.println("e: ride car");

        else if( isRiding )
            System.out.println("l: leave bike");

        else if( isOnTopOfBike )
            System.out.println("e: ride bike");


        System.out.print("-> ");
        String s = scanner.next();

        int px = player.getX();
        int py = player.getY();

        if(s.equals("z") || s.equals("w"))
        {
            if( map.getTile(px + 0, py - 1).accessible( player ) )
            {
                player.move(Dir.Up);
                map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("s"))
        {
            if( map.getTile(px + 0, py + 1).accessible( player ) )
            {
                player.move(Dir.Down);
                map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("q") || s.equals("a"))
        {
            if( map.getTile(px - 1, py + 0).accessible( player ) )
            {
                player.move(Dir.Left);
                map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("d"))
        {
            if( map.getTile(px + 1, py + 0).accessible( player ) )
            {
                player.move(Dir.Right);
                map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("quit") || s.equals("exit"))
        {
            System.out.println("Exiting game..");
            System.exit(0);
        }
        else if( isOnTopOfCar && s.equals("e") )   // entering bike
        {
            // Allow for swapping shifts
            Shift shift = null;
            if( isInstance( player.getShift(), BikeShift.class ))
                shift = new BikeShift();

            player.setShift( new CarShift());   // set player shift to Car
            Tile tile = map.getTile( player.getX(), player.getY() );
            if( isInstance( tile, TileWithShift.class) )
            {
                TileWithShift casted_tile = ( TileWithShift ) tile;
                casted_tile.setShift( shift );  // set tile shift to Bike or null
            }
        }
         else if( isDriving && s.equals("l") )       // leaving car
        {

            player.setShift( new WalkShift() );
            Tile tile = map.getTile( player.getX(), player.getY() );
            if( isInstance( tile, TileWithShift.class) )
            {
                TileWithShift casted_tile = ( TileWithShift ) tile;
                casted_tile.setShift( new CarShift());
            }
        }
        else if( isOnTopOfBike && s.equals("e") )   // entering bike
        {

            player.setShift( new BikeShift());  // set player shift to Bike
            Tile tile = map.getTile( player.getX(), player.getY() );
            if( isInstance( tile, TileWithShift.class) )
            {
                TileWithShift casted_tile = ( TileWithShift ) tile;
                casted_tile.setShift( null );  // set tile shift to null
            }
        }
        else if( isRiding && s.equals("l" ))        // leaving bike
        {
            player.setShift( new WalkShift());
            Tile tile = map.getTile( player.getX(), player.getY() );
            if( isInstance( tile, TileWithShift.class) )
            {
                TileWithShift casted_tile = ( TileWithShift ) tile;
                casted_tile.setShift( new BikeShift() );    // set tile shift to bike
            }
        }

    }

    public boolean loopOnce()
    {
        if( !player.isAlive() ) return false; // quit the game

        System.out.println(this.getASCII());
        // TODO print event
        System.out.println("Health: " + player.getHealth() + "\t | Hydration: \t" + player.getHydration());
        System.out.println("Morale: " + player.getMorale() + "\t | Satiety: \t" + player.getSatiety() + "\n");
        this.promptChoice();

        System.out.print("\033[H\033[2J"); // clear screen

        return true;
    }

    public static void main(String[] args)  //static method
    {

        Game game = new Game();
        game.promptStartOptions();
        game.init();

        while (true)
        {
            if (!game.loopOnce()) break;
        }
    }
}
