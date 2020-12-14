package shifts;

public abstract class Shifts {

    protected char ASCII;
    protected float deathChance;

    public abstract void changeStats(Player player);

    public char getASCII() {
        return ASCII;
    }



}
