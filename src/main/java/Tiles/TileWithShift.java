package Tiles;

import player.Player;
import shifts.Shift;

public abstract class TileWithShift extends Tile{

    public Shift shift;

    public TileWithShift() {
        super( );
    }

    public char getASCII() {
        if( shift != null )
            return shift.getASCII();
        else
            return ASCII;
    }

    public void setShift( Shift shift )
    {
        this.shift = shift;
    }

    public abstract void enterTile(Player player);
    public abstract boolean accessible( Player player );


}
