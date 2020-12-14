package player;

public class HommePresse extends Player{

    public HommePresse(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 100;
        hydratation = 75;
        satiety = 75;
        morale = 50;
    }
}
