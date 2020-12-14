package java.Tiles;

// TODO remove enum, replace with class Player
enum Player
{}

public abstract class Tile {
    private int x;
    private int y;
    protected char ASCII = ' ';

    Tile( int x, int y )
    {
        x = x;
        y = y;
    }

    public int getX() { return x ;}
    public int getY() { return y ;}
    public char getASCII() { return ASCII ;}

    // Method to be override by subclasses
    abstract void enterTile( Player player );
    abstract boolean accessible( Player player );

}
