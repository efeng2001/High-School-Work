package gridworld;

import info.gridworld.actor.ActorWorld;

public class EcosystemRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new VenusFlytrap());
		world.add(new Fly());
		world.add(new Bee());
		world.show();
	}
}