package road;

import Tiles.Tile;
import player.Player;

public class SideWalkTile extends Tile {

    public SideWalkTile(){
        super( );
        ASCII = '#';
    }

    @Override
    public boolean accessible(Player player) {
        // TODO: conditions to enter the tile
        return true;
    }

    @Override
    public void enterTile(Player player) {
        // TODO: what happens when the player enter the tile
    }
}
