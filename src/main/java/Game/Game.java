package Game;

public class Game
{
    public Map map;

    public Game( int x, int y)
    {
        map = new Map(x, y);
    }


    public void start()
    {

    }

    public void displayMap()
    {
        System.out.println( map.getASCII() ); // display the map
    }

    public static void main(String args[])  //static method
    {
        Game game = new Game(64, 16);
        System.out.println(game.map.getASCII());
    }
}
