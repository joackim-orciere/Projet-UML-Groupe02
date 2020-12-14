package player;

public abstract class Player {
    private int x;
    private int y;
    protected int health;
    protected int hydration;
    protected int satiety;
    protected int morale;
    private String pseudo;
    private int nbrDiploma = 0;
    protected boolean driver = true;
    protected boolean swimsuit = false;
    protected int fines = 0;
    protected boolean alive = true;

    protected Player(int x, int y, String pseudo) {
        this.x = x;
        this.y = y;
        this.pseudo = pseudo;
    }

    //Getters
    public int getX(){ return this.x;}

    public int getY(){ return this.y;}

    public int getHealth(){ return this.health;}

    public int getHydration(){ return this.hydration;}

    public int getSatiety(){ return this.satiety;}

    public int getMorale(){ return this.morale;}

    public String getPseudo(){ return this.pseudo;}

    public int getNbrDiploma(){ return this.nbrDiploma;}

    public boolean getDriver(){ return this.driver;}

    public boolean getSwimsuit(){ return this.swimsuit;}

    public int getFines(){ return this.fines;}

    public boolean isAlive(){ return this.alive;}

    //Setters
    public void kill(){ this.alive = false;}

    public void changeHealth( int delta) { this.health = this.health + delta;}

    public void changeHydration( int delta) { this.hydration = this.hydration + delta;}

    public void changeSatiety( int delta) { this.satiety = this.satiety + delta;}

    public void changeMorale( int delta) { this.morale = this.morale + delta;}
}
