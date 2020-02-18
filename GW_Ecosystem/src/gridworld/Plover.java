package gridworld;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Plover extends Critter {
	// plover is hungry at first, low possibility to die 0.1
	// plover can see six blocks ahead 
	// if plover sees dirty croc, it lands on the croc and cleans it 
	// it spits out by the clean croc, and turns into not hungry plover
	// high possibility of plover getting hungry 0.7 
	// if plover dies it becomes meat 
	
	private boolean hungry = false;
	
	public boolean getHungry()
	{
		return hungry;
	}

	public void setHungry(boolean hungry)
	{
		this.hungry = hungry;
	}
	
	@Override
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		if(getLocation()!=null)
		{
			int dir = getDirection();
			Location loc = getLocation();
			for(int j=0; j<2; j++) {
				for(int i =-45; i<50; i+=45){
					Location loc2 = loc.getAdjacentLocation(dir+i);;
					if(getGrid().isValid(loc2)&&getGrid().get(loc2)!=null){
						actors.add(getGrid().get(loc2));
					}
				}
				loc = loc.getAdjacentLocation(dir);
			}
		}
		return actors;
	}

	@Override
	public void processActors(ArrayList<Actor> actors) 
	{
		for (Actor a : actors) {
			if (a instanceof Crocodile && ((Crocodile) a).getDirty() && hungry==true) {
				((Crocodile)a).enterCroc(this);
				hungry = false;
				this.removeSelfFromGrid();
			}
		}	
	}
	
	public ArrayList<Location> getMoveLocations()
	{	
		if(getLocation()!=null)
			return getGrid().getEmptyAdjacentLocations(getLocation());
		return new ArrayList<Location>();
	}
	
	
	@Override
	public void makeMove(Location loc)
	{
		Location l = getLocation();
		Grid<Actor> grid = getGrid();
		if (loc != null) {
			setDirection(getLocation().getDirectionToward(loc));
			moveTo(loc);
			if(Math.random()>0.7)
			{
				hungry = true;
			}
			if (hungry && Math.random()<0.1)
			{
				removeSelfFromGrid();
				Meat meat = new Meat();
				meat.putSelfInGrid(grid, l);
			}
		}
	}


}
