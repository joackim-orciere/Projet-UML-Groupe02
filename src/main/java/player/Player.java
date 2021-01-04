package player;

import shifts.Shift;
import shifts.WalkShift;

public abstract class Player {
    protected int x;
    protected int y;
    public int prev_x;
    public int prev_y;
    private Shift shift;

    protected int health;
    protected int hydration;
    protected int satiety;
    protected int morale;

    private String pseudo;
    private double diplomaChance = 0.3;
    private int nbrDiploma = 0;
    protected boolean driver = true;
    protected boolean swimsuit = false;
    protected int fines = 0;
    protected boolean alive = true;

    protected Player(int x, int y, String pseudo) {
        this.x = x;
        this.y = y;
        this.pseudo = pseudo;
        this.shift = new WalkShift(); // default shift
    }

    public String move(Dir dir )
    {

        switch (dir) {
            case Up:
                prev_y = y;
                y += -1;
                break;
            case Down:
                prev_y = y;
                y += 1;
                break;
            case Left:
                prev_x = x;
                x += -1;
                break;
            case Right:
                prev_x = x;
                x += 1;
                break;
        }

        return "";
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

    public double getDiplomaChance(){ return this.diplomaChance; }

    public void changeNbrDiploma( int delta ){ nbrDiploma += delta ;}

    public boolean getDriver(){ return this.driver;}

    public boolean getSwimsuit(){ return this.swimsuit;}

    public void setSwimsuit( boolean b ){ swimsuit = b;}

    public int getFines(){ return this.fines;}

    public boolean isAlive(){ return this.alive;}

    public Shift getShift(){ return this.shift;}

    public void setShift( Shift shift ){ this.shift = shift;}

    //Setters
    public void kill(){ this.alive = false;}

    public void changeFines( int delta )
    {
        this.fines += delta;
        if( this.fines >= 3 )
        {
            kill();
        }
    }

    public void checkStats(){
        if(getHealth() <=0 || getHydration() <=0 || getSatiety() <=0 || getMorale() <=0)
        {
            this.kill();
        }
        else if(getHealth() > 100){ this.health = 100; } // Normalement inutile car rien ne peut faire remonter la vie

        else if(getHydration() > 100){ this.hydration = 100; }

        else if(getSatiety() > 100){ this.satiety = 100; }

        else if(getMorale() > 100){ this.morale = 100; }
    }

    public void changeDiplomaChance( double delta )
    {
        this.diplomaChance += delta;
        if( diplomaChance > 1.0 )
            diplomaChance = 1.0;
    }

    public void changeHealth( int delta) {
        this.health = this.health + delta;
        this.checkStats();
    }

    public void changeHydration( int delta) {
        this.hydration = this.hydration + delta;
        this.checkStats();
    }

    public void changeSatiety( int delta) {
        this.satiety = this.satiety + delta;
        this.checkStats();
    }

    public void changeMorale( int delta) {
        this.morale = this.morale + delta;
        this.checkStats();
    }

    public String getASCII() {
        return shift.getPlayerASCII();
    }
}
