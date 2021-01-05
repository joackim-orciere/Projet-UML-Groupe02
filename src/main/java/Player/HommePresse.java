package Player;

import Shifts.BikeShift;
import Shifts.CarShift;

import static Misc.Misc.isInstance;

public class HommePresse extends Player{

    public HommePresse(int x, int y, String pseudo) {
        super(x, y, pseudo);
        health = 100;
        hydration = 75;
        satiety = 75;
        morale = 50;
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

        changeMorale(-2 ); // Standard character malus

        if( isInstance( getShift(), CarShift.class ))
        {
            if( Math.random() < 0.05 ) // Fine
            {
                changeFines(+1 );
                s += "You got caught speeding, by the police: Fines: +1\n";
                if( getFines() >= 3 )
                {
                    s += "You have been put to jail. \n";
                }
            }
            if( Math.random() < 0.02 ) // Accident
            {
                s += "You had a car crash\n";
                kill();
            }
        }
        else if( isInstance( getShift(), BikeShift.class ))
        {
            if( Math.random() < 0.05 ) // Accident
            {
                s += "You've been hit by a car\n";
                kill();
            }
        }

        return s;
    }

}
