package gridworld;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import info.gridworld.gui.AbstractDisplay;

public class HeManDisplay extends AbstractDisplay
{
	@Override
	public void draw(Object obj, Component comp, Graphics2D g2)
	{
		if (obj == null)
		{
			return;
		}

		HeMan heMan = (HeMan) obj;

		String name;
		if (heMan.getDirty())
		{
			name = "HeMan.gif";
		} else
		{
			name = "HeMan_clean.gif";
		}

		ImageIcon icon = new ImageIcon(this.getClass().getResource(name));
		Image img = icon.getImage();

		g2.translate(-0.5, -0.5);
		g2.drawImage(img, 0, 0, 1, 1, comp);
	}
}