package Game;

import player.Hippie;
import player.HommePresse;
import player.Player;
import player.Standard;

import java.util.Scanner;

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

    public void displayMap()
    {
        System.out.println( map.getASCII() ); // display the map
    }

    public void promptOptions()
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
    }

    public static void main(String args[])  //static method
    {

        Game game = new Game();
        game.promptOptions();
        game.init();
        System.out.println(game.map.getASCII());
    }
}
