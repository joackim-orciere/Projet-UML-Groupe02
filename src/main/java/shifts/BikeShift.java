package shifts;

import player.Player;

public class BikeShift extends Shift{

    public BikeShift(){
        super();
        ASCII = '%';
    }

    @Override
    public void changeStats(Player player) {
        player.changeHydration(-5);
        player.changeSatiety(-5);
    }



}
