package Player;

import Shifts.BikeShift;
import Shifts.CarShift;
import Shifts.WalkShift;

import static Misc.Misc.isInstance;

public class Standard extends Player{

    public Standard(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 75;
        hydration = 75;
        satiety = 75;
        morale = 75;
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

        changeHealth(-1 ); // Standard character malus


        if( isInstance( getShift(), WalkShift.class ))
        {
            changeHydration(-10);
            changeSatiety(-10);
        }
        else if( isInstance( getShift(), CarShift.class ))
        {
            changeMorale(-2);
            if( Math.random() < 0.02 ) // Accident
            {
                s += "You had a car crash\n";
                kill();
            }
            if( Math.random() < 0.05 ) // Fine
            {
                changeFines(+1 );
                s += "You got caught speeding, by the police: Fines: +1\n";
                if( getFines() >= 3 )
                {
                    s += "You have been put to jail. \n";
                }
            }
        }
        else if( isInstance( getShift(), BikeShift.class ))
        {
            changeSatiety(-5);
            changeHydration(-5);
            if( Math.random() < 0.05 ) // Accident
            {
                s += "You've been hit by a car\n";
                kill();
            }
        }

        return s;
    }
}
