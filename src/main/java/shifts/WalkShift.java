package shifts;

import player.Player;

public class WalkShift extends Shift {

    public WalkShift() {
        ASCII= '&';
    }

    public void changeStats(Player player) {
        player.changeHydration(-10);
        player.changeSatiety(-10);
    }
}
