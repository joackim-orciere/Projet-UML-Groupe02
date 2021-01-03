package shifts;

import player.Player;

public abstract class Shift {

    protected char ASCII;

    public abstract void changeStats(Player player);

    public char getASCII() {
        return ASCII;
    }



}
