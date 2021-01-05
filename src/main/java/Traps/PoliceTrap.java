package Traps;

import Player.Player;

public class PoliceTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeMorale(-1 );
        return "You encountered a redlight: -1 morale\n";
    }
}
