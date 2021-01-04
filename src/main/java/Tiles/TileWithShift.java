package Tiles;

import player.Player;
import shifts.Shift;

public abstract class TileWithShift extends Tile{

    public Shift shift;

    public TileWithShift() {
        super( );
    }

    @Override
    public String getASCII() {
        if( shift != null )
            return shift.getASCII();
        else
            return ASCII + "";
    }

    public void setShift( Shift shift )
    {
        this.shift = shift;
    }

    public String enterTile(Player player)
    {
        return "";
    }
    public abstract boolean accessible( Player player );


}
