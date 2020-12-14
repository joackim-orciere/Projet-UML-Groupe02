package java;

// TODO remove enum, replace with class Player
enum Player
{}

public abstract class Tile {
    private int x;
    private int y;
    private char ASCII;

    public int getX() { return x ;}
    public int getY() { return y ;}
    abstract void enterTile( Player player );
    abstract void accessible( Player player );
    abstract void getASCII();
}
