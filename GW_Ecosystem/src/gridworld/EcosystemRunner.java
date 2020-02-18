package gridworld;

import info.gridworld.actor.ActorWorld;

public class EcosystemRunner
{
	public static ActorWorld world;
	
	public static void main(String[] args)
	{
		world = new ActorWorld();
		world.add(new Plover());
		world.add(new Crocodile());
		world.add(new MeatGenerator());
		world.show();
		
	}
}