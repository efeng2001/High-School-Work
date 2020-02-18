package gridworld;

import info.gridworld.actor.Actor;

public class MeatGenerator extends Actor {

	@Override 
	public void act()
	{
		
		double random = Math.random();
		if (random < 0.25)
		{
			EcosystemRunner.world.add(new Meat());
		}
	}
}
