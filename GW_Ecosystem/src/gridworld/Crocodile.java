package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Crocodile extends Critter {
	// dirty crocodile move one block at a time randomly 
	// if see meat, eat meat, become not hungry 
	// it can see front 3 blocks 
	// after eating meat, high possibility to become dirty croc and a very low possibility that it will die 
	// if bird sees croc and cleans it, croc becomes clean and hungry 
	
	private boolean dirty = false;
	private boolean hungry = true;
	ArrayList<Plover> plovers = new ArrayList<Plover>();
	
	public void enterCroc(Plover plover)
	{
		plovers.add(plover);
	}
	
	@Override
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		int dir = getDirection();
		for(int i =-45; i<50; i+=45){
			Location loc = getLocation().getAdjacentLocation(dir+i);
			if(getGrid().isValid(loc)&&getGrid().get(loc)!=null){
				actors.add(getGrid().get(loc));
			}
		}
		return actors;
	}

	@Override
	public void processActors(ArrayList<Actor> actors) 
	{
		for (Actor a : actors) {
			if (a instanceof Meat) {
				a.removeSelfFromGrid();
				hungry = false; 
				if (Math.random() > 0.2){
					dirty = true;
				}
			}
		}	
	}

	@Override
	public void makeMove(Location loc)
	{
		if (loc == null) {
			removeSelfFromGrid();
		}else {
			setDirection(getLocation().getDirectionToward(loc));
			moveTo(loc);
			if ((dirty || hungry) && Math.random()<0.1)
			{
				removeSelfFromGrid();
			}
			if(!plovers.isEmpty() && Math.random()>0.3)
			{
				Plover p = new Plover();
				ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
				int randomLoc = (int)(Math.random()*locs.size());
				p.putSelfInGrid(getGrid(), locs.get(randomLoc));
				dirty = false;
				plovers.remove(0);
			}
		}
	}
	
	public boolean getDirty()
	{
		return dirty;
	}

}
