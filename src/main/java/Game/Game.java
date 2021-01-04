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

    private static final Scanner scanner = new Scanner(System.in);

    private String eventString = "";

    private int count = 0;

    private int playerType;
    private int mapType;
    private String playerName;


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

    public void promptStartOptions()
    {

        System.out.print("Choose your character: [1/2/3] \n1: Standard \n2: Hippie \n3: Homme pressé \n -> " );
        try {
            playerType = scanner.nextInt();
        }
        catch( Exception e)
        {
            System.out.println("Error, default: Standard");
            playerType = 1;
        }
        if( playerType < 1 || playerType > 3 )
        {
            System.out.println("Error, default: Standard");
            playerType = 1;
        }

        System.out.print("Choose your name: \n -> ");
        scanner.nextLine();
        playerName = scanner.nextLine();

        System.out.print("Choose the size of the map: [1/2/3] \n1: Small \n2: Medium \n3: Large \n -> ");
        try {
            mapType = scanner.nextInt();
        }
        catch( Exception e )
        {
            System.out.println("Error, default: Medium");
            mapType = 2;
        }
        if( mapType < 1 || mapType > 3 )
        {
            System.out.println("Error, default: Medium");
            mapType = 2;
        }

        System.out.print("Start the game ? [Y/n]: \n -> ");
        String s = scanner.next();

        if( s.equals("N") || s.equals("no") || s.equals("No") || s.equals("n"))
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

        eventString = "";

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


        if(s.equals("z") || s.equals("w"))    // CharAt allow for smoother movement if for exemple "ww" is entered
        {
            if( map.getTile(px + 0, py - 1).accessible( player ) )
            {
                eventString += player.move(Dir.Up);
                eventString += map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("s"))
        {
            if( map.getTile(px + 0, py + 1).accessible( player ) )
            {
                eventString += player.move(Dir.Down);
                eventString += map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("q") || s.equals("a"))
        {
            if( map.getTile(px - 1, py + 0).accessible( player ) )
            {
                eventString += player.move(Dir.Left);
                eventString += map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("d"))
        {
            if( map.getTile(px + 1, py + 0).accessible( player ) )
            {
                eventString += player.move(Dir.Right);
                eventString += map.getTile( player.getX(), player.getY()).enterTile( player );
            }
        }
        else if(s.equals("exit") || s.equals("quit"))
        {
            System.out.println("Exiting game..");
            System.exit(0);
        }
        else if( isOnTopOfCar && s.equals("e") )   // entering car
        {
            // Allow for swapping shifts
            Shift shift = null;
            if( isInstance( player.getShift(), BikeShift.class ))
                shift = new BikeShift();

            if( !isInstance( player, Hippie.class )) // only if not hippie
            {
                player.setShift(new CarShift());   // set player shift to Car
                Tile tile = map.getTile(player.getX(), player.getY());
                if (isInstance(tile, TileWithShift.class)) {
                    TileWithShift casted_tile = (TileWithShift) tile;
                    casted_tile.setShift(shift);  // set tile shift to Bike or null
                }
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
        else if( isRiding && s.equals("l"))        // leaving bike
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

        System.out.println(eventString + "\n");

        // TODO print event
        System.out.println("Health: " + player.getHealth() + "\t | Hydration: \t" + player.getHydration());
        System.out.println("Morale: " + player.getMorale() + "\t | Satiety: \t" + player.getSatiety());
        System.out.println("Intel:  " + (int) (player.getDiplomaChance()*100) + "%\t | Diplomas: \t" + player.getNbrDiploma());
        System.out.println("Fines:  " + player.getFines() + "\n");
        this.promptChoice();

        System.out.print("\033[H\033[2J"); // clear screen

        return true;
    }

    public static void main(String[] args)  //static method
    {


        boolean playing = true;

        while( playing )
        {
            System.out.print("\033[H\033[2J"); // clear screen

            Game game = new Game();
            game.promptStartOptions();
            game.init();

            while (true) {
                if (!game.loopOnce()) break;
                game.count += 1;
            }

            System.out.println(game.getASCII());

            System.out.println( game.eventString + "\n");

            System.out.println("Health: " + game.player.getHealth() + "\t | Hydration: \t" + game.player.getHydration());
            System.out.println("Morale: " + game.player.getMorale() + "\t | Satiety: \t" + game.player.getSatiety());
            System.out.println("Intel:  " + (int) (game.player.getDiplomaChance()*100) + "%\t | Diplomas: \t" + game.player.getNbrDiploma() + "\n");

            System.out.println("You Died.\n");
            System.out.println("----{ Score }----");
            System.out.println("Name:    \t" + game.playerName);
            System.out.println("Turns:   \t" + game.count);
            System.out.println("Diplomas:\t" + game.player.getNbrDiploma() + "\n");

            System.out.println("Play Again ? y/N\n -> ");
            scanner.nextLine(); // necessary, I don't know why
            String s = scanner.nextLine();

            if( s.equals("y") || s.equals("Y") )
            {
                playing = true;
            }
            else
            {
                playing = false;
                System.out.println("Exiting game..");
            }
        }

        scanner.close();
    }
}
