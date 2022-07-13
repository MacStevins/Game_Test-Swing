package macstevins.game.test1.core.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class Player extends JPanel {

	private static final long serialVersionUID = -2139801767089893622L;

	private int[] x = new int[3], y = new int[3];

	public Player(Color col, Dimension size, Point loc) {
		
		setBackground(col);
		setBounds(x[0] = loc.x - (size.width / 2), y[0] = loc.y - (size.height / 2), size.width, size.height);
		setName("plr");
	
	}

}
