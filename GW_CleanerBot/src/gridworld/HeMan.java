package gridworld;

import info.gridworld.actor.Actor;

public class HeMan extends Actor implements Cleanable
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
		if (cleanCount % 3 == 0) {
			dirty = false;
		} else {
			dirty = true;
		}
		
	}

	@Override
	public void act()
	{
		// DO NOTHING
	}
}