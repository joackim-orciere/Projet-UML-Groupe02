package Traps;

import Player.Player;

public class RedLightTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeHealth(-1 );
        return "You encountered a redlight: -1 health\n";
    }
}
