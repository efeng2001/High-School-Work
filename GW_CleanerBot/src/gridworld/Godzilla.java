package gridworld;

import info.gridworld.actor.Actor;

public class Godzilla extends Actor implements Cleanable
{
	private boolean dirty = true;

	public boolean getDirty()
	{
		return dirty;
	}

	public void clean()
	{
		dirty = false;
	}

	@Override
	public void act()
	{
		// DO NOTHING
	}
}