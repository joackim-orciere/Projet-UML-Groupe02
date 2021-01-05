package Tiles;

import Player.Player;

public class CrossingTile extends Tile {

    public CrossingTile()
    {
        super();
        ASCII = '+'; // set the ASCII value for the class

    }

    @Override
    public boolean accessible(Player player) {
        return true; // always accessible
    }

    // TODO add possiblity for cars to be parked -> add shift attribute like RoadTile
}
