package macstevins.game.test1.core.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class Object extends JPanel {

	private static final long serialVersionUID = -5162324794249304844L;

	public Object(Color col, Dimension size, Point loc) {
		
		setBackground(col);
		setBounds(loc.x, loc.y, size.width, size.height);
	
	}

}
