package Traps;

import Player.Player;

public class StrollerTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeMorale(-2 );
        return "You encounter a stroller: -2 morale\n";
    }
}
