package Traps;

import Player.Player;

public class BananaPeelTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeHealth(-3 );
        return "You slipped on a banana peel: -3 health\n";
    }
}
