package gridworld;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import info.gridworld.gui.AbstractDisplay;

public class PloverDisplay extends AbstractDisplay {

	@Override
	public void draw(Object obj, Component comp, Graphics2D g2) {
		
		if (obj == null)
		{
			return;
		}

		Plover plover = (Plover) obj;

		String name;
		if (plover.getHungry())
		{
			name = "Plover_hungry.gif";
		} else
		{
			name = "Plover.gif";
		}

		ImageIcon icon = new ImageIcon(this.getClass().getResource(name));
		Image img = icon.getImage();

		g2.translate(-0.5, -0.5);
		g2.drawImage(img, 0, 0, 1, 1, comp);
		
	}

}
