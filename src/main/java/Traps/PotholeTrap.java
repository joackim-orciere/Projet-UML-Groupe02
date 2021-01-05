package Traps;

import Player.Player;

public class PotholeTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeHydration(-2 );
        player.changeSatiety(-2 );
        return "You encountered a pothole: -2 hydration, -2 satiety\n";
    }
}
