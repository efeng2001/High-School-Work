package gridworld;

import info.gridworld.actor.Actor;

public class Muk extends Actor implements Cleanable
{
	private boolean dirty = true;
	private int cleanCount = 0;

	public boolean getDirty()
	{
		return dirty;
	}

	public void clean()
	{
		cleanCount++;
		if (cleanCount == 3) {
			dirty = false;
			cleanCount = 0;
		}
	}

	@Override
	public void act()
	{
		// DO NOTHING
	}
}