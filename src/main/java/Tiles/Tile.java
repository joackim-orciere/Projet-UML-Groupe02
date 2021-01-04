package Tiles;

import player.Player;

public abstract class Tile {

    // ANSI color escape sequences
    public static final String COLOR_DEFAULT    = "\u001B[0m";
    public static final String COLOR_BLACK      = "\u001B[30m";
    public static final String COLOR_RED        = "\u001B[31m";
    public static final String COLOR_GREEN      = "\u001B[32m";
    public static final String COLOR_YELLOW     = "\u001B[33m";
    public static final String COLOR_BLUE       = "\u001B[34m";
    public static final String COLOR_PURPLE     = "\u001B[35m";
    public static final String COLOR_CYAN       = "\u001B[36m";
    public static final String COLOR_WHITE      = "\u001B[37m";

    protected char ASCII;

    public Tile() {

    }

    public String getASCII() {
            return ASCII + "";
    }

    public String enterTile(Player player)
    {
        return "";
    }
    public abstract boolean accessible( Player player );


}
