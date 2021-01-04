package Tiles.Buildings;

import Tiles.Tile;

public abstract class BuildingTile extends Tile
{
    String name;
    BuildingTile()
    {
        super();
    }

    @Override
    public String getASCII() {
        return Tile.COLOR_PURPLE + ASCII + Tile.COLOR_DEFAULT;
    }


}
