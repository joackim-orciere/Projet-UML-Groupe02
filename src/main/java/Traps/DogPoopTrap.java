package Traps;

import Player.Player;

public class DogPoopTrap implements Trap
{
    @Override
    public String activateTrap(Player player)
    {
        player.changeSatiety(-1 );
        return "You walked into a dog poop: -1 satiety\n";
    }
}
