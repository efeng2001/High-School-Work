package gridworld;

import info.gridworld.actor.ActorWorld;

public class SimulationRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new CleanerBot());
		world.add(new Poop());
		world.add(new Trump());
		world.add(new Muk());
		world.add(new Pusheen());
		world.add(new HeMan());
		world.add(new Godzilla());
		world.add(new NBA());
		world.add(new BlackHole());
		world.add(new Devil());
		world.show();
	}
}