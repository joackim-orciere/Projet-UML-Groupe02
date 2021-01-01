package road;

public class Road extends Tile {

    Road(int x, int y){
        super(x, y);
        ASCII = ' ';
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
