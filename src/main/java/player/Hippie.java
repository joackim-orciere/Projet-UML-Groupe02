package player;

public class Hippie extends Player{
    public Hippie(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 75;
        hydration = 50;
        satiety = 50;
        morale = 100;
        driver = false;
    }
}
