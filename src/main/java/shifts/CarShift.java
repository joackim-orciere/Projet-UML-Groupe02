package shifts;

import player.Player;

public class CarShift extends Shift{

    public CarShift(){
        super();
        ASCII = '$';

    }

    @Override
    public void changeStats(Player player) {
        player.changeMorale(-2);
    }


}
