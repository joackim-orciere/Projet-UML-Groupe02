package player;

public class Standard extends Player{

    public Standard(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 75;
        hydratation = 75;
        satiety = 75;
        morale = 75;
    }
}
