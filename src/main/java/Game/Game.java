package Game;

public class Game
{
    public Map map;


    public void start()
    {

    }

    public void displayMap()
    {
        System.out.println( map.getASCII() ); // display the map
    }

    public static void main(String args[])  //static method
    {
        Game game = new Game();
        System.out.println(game.map.getASCII());
    }
}
