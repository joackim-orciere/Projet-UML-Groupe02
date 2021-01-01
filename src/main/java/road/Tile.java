package road;
// TODO remove enum, replace with class Title
public abstract class Tile {
    private int x;
    private int y;
    protected char ASCII;

    public Tile(int x, int y)
    {
        x = x;
        y = y;
    }

    public int getX() { return x ;}
    public int getY() { return y ;}
    public char getASCII() { return ASCII ;}

    public abstract void enterTile(Player player);
    public abstract boolean accessible( Player player );
}
