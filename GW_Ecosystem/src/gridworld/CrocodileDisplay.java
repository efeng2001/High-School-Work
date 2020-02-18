package gridworld;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import info.gridworld.gui.AbstractDisplay;

public class CrocodileDisplay extends AbstractDisplay {

	@Override
	public void draw(Object obj, Component comp, Graphics2D g2) {
		
		if (obj == null)
		{
			return;
		}

		Crocodile crocodile = (Crocodile) obj;

		String name;
		if (crocodile.getDirty())
		{
			name = "Crocodile_dirty.gif";
		} else
		{
			name = "Crocodile.gif";
		}

		ImageIcon icon = new ImageIcon(this.getClass().getResource(name));
		Image img = icon.getImage();

		g2.translate(-0.5, -0.5);
		g2.rotate(-Math.PI/2 , 0.5, 0.5);
		g2.drawImage(img, 0, 0, 1, 1, comp);
		
	}

}
