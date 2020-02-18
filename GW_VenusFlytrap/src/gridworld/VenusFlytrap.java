package gridworld;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class VenusFlytrap extends Critter {

	/**
	 * TODO: This particular species of Venus Flytrap has evolved to use a long
	 * tongue to capture flies. Override getActors() so that it can eat flies up to
	 * two squares away.
	 */
	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid <Actor> grid = getGrid();
		int myRow = getLocation().getRow();
		int myCol = getLocation().getCol();
		
		for(int i=myRow-2; i<myRow+3; i++)
		{
			for(int j=myCol-2; j<myCol+3; j++)
			{
				Location loc = new Location(i,j);
				if(grid.isValid(loc) && grid.get(loc)!=null)
				{
					actors.add(getGrid().get(loc));
				}
			}
		}
		return actors;
	}

	/**
	 * TODO: Override processActors() so that the Venus Flytrap eats ALL flies that
	 * it can reach. Make sure not to eat any bees as they are the Venus Flytrap's
	 * primary pollinator.
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (a instanceof Fly)
				a.removeSelfFromGrid();
		}
	}

	/**
	 * TODO: Override getMoveLocations() so that the Venus Flytrap doesn't move.
	 */
	@Override
	public ArrayList<Location> getMoveLocations() {
		return new ArrayList<Location>();	
	}	
}
	