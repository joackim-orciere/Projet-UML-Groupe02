package player;

public abstract class Player {
    private int x;
    private int y;
    protected int health;
    protected int hydratation;
    protected int satiety;
    protected int morale;
    private String pseudo;
    private int nbrDiploma = 0;
    protected boolean driver = true;
    protected boolean swimsuit = false;
    protected int fines = 0;
    public boolean alive = true;

    protected Player(int x, int y, String pseudo) {
        this.x = x;
        this.y = y;
        this.pseudo = pseudo;
    }
}
