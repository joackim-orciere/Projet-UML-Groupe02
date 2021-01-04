package player;

import shifts.BikeShift;
import shifts.WalkShift;

import static Misc.Misc.isInstance;

public class Hippie extends Player{
    public Hippie(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 75;
        hydration = 50;
        satiety = 50;
        morale = 100;
        driver = false;
    }

    @Override
    public void changeMorale( int delta) // his morale cannot go down
    {
        if( delta < 0 ) delta = -delta;
        this.morale = this.morale + delta;
        this.checkStats();
    }

    @Override
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

        String s = "";


        if( isInstance( getShift(), WalkShift.class ))
        {
            changeHydration(-10 * 2);
            changeSatiety(-10 * 2);
        }
        else if( isInstance( getShift(), BikeShift.class ))
        {
            changeSatiety(-5 * 2);
            changeHydration(-5 * 2);
            if( Math.random() < 0.05 ) // Accident
            {
                s += "You've been hit by a car\n";
                kill();
            }
        }

        return s;
    }
}
