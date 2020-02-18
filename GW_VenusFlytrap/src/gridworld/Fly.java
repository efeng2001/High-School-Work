package gridworld;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Fly extends Critter {

	private boolean danger = false;

	// TODO: Add a constructor to make the fly face a random direction when created.
	// Make sure the direction is a multiple of 45 (including 0)

	public Fly()
	{
		setDirection(((int)(Math.random()*8))*45);
	}
	/**
	 * TODO: This particular species of fly has evolved to look very far directly in
	 * front of itself. Override getActors() to return only the actors that are one,
	 * two, or three squares directly in front of the fly.
	 */
	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid <Actor> grid = getGrid();
		int dir = getDirection();
		Location loc = getLocation().getAdjacentLocation(dir);
		
		for(int i=0; i<3; i++) {
			if(grid.isValid(loc) && grid.get(loc)!=null){
				actors.add(getGrid().get(loc));
			}
			loc = loc.getAdjacentLocation(dir);
		}
		
		
		return actors;
	}

	/**
	 * TODO: Override processActors() to set the instance variable danger to true if
	 * the fly sees a Venus Flytrap.
	 */
	@Override
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (a instanceof VenusFlytrap)
				danger = true;
		}
	}

	/**
	 * TODO: Override getMoveLocation() so that if danger is true the fly tries to
	 * fly away. For example, it could try to move one square in the opposite
	 * direction that it is facing. If that is an invalid location, it could try to
	 * move diagonally backwards or perhaps to either side. Make sure to set danger
	 * to false at the end of this method. If the fly is not in danger, the
	 * functionality of super.getMoveLocations() seems appropriate.
	 */
	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		Grid <Actor> grid = getGrid();
		int dir = getDirection();
		
		if(danger){
			locations.addAll(grid.getEmptyAdjacentLocations(getLocation()));
			locations.remove(getLocation().getAdjacentLocation(dir));
			locations.remove(getLocation().getAdjacentLocation(dir+45));
			locations.remove(getLocation().getAdjacentLocation(dir-45));			
		}else{
			return super.getMoveLocations();
		}
		return locations;
	}

	/**
	 * TODO: Override makeMove() to change the direction the fly is facing to match
	 * the direction it moved. Note that if you'd like to call super.makeMove(loc),
	 * it does not need to be the first line. Only super() has to be the first line
	 * in the constructor.
	 */
	@Override
	public void makeMove(Location loc) {
		if (loc == null)
			removeSelfFromGrid();
		else
			setDirection(getLocation().getDirectionToward(loc));
			super.makeMove(loc);
	}
}
