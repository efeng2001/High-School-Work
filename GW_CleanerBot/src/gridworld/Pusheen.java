package gridworld;

import info.gridworld.actor.Actor;

public class Pusheen extends Actor implements Cleanable
{
	private boolean dirty = true;

	public boolean getDirty()
	{
		return dirty;
	}

	public void clean()
	{
		dirty = !dirty;
	}

	@Override
	public void act()
	{
		// DO NOTHING
	}
}