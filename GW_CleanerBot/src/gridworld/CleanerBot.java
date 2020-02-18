package gridworld;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class CleanerBot extends Critter {
	/**
	 * Program the CleanerBot to clean() Godzilla, HeMan, Muk, the NBA, Poop,
	 * Pusheen, and Trump. Note that the CleanerBot is unable to clean BlackHoles
	 * and the Devil. The CleanerBot should try to clean() when it moves adjacent to
	 * another Actor. You do not need to modify how the CleanerBot moves.
	 */

	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		for (Actor a : actors)
		{
			if(a instanceof Cleanable) {
				((Cleanable)a).clean();
			}
		}
	}

	@Override
	public ArrayList<Location> getMoveLocations() {
		return getGrid().getEmptyAdjacentLocations(getLocation());
	}
}