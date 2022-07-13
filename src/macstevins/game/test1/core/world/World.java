package macstevins.game.test1.core.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class World extends JPanel {

	private static final long serialVersionUID = 1951339210557743847L;

	private ArrayList<Object> objs = new ArrayList<Object>();
	private Player plr;

	public World() {}

	public World addObject(Color col, Dimension size, Point loc) {
		
		objs.add(new Object(col, size, loc));
		return this;
	
	}

	public World addObject(Object obj) {
		
		objs.add(obj);
		return this;
	
	}

	public World addPlayer(Player plr) {
		
		this.plr = plr;
		return this;
	
	}

	public void init(Dimension size) {
		
		setPreferredSize(size);
		
		add(plr);
		for(int a = 0; a < objs.size(); a++) add(objs.get(a));
	
	}

//	@Override
//	@Deprecated
//	public Component add(Component comp) { return null; }
//
//	@Override
//	@Deprecated
//	public Component add(Component comp, int index) { return null; }
//
//	@Override
//	@Deprecated
//	public Component add(String name, Component comp) { return null; }
//
//	@Override
//	@Deprecated
//	public void add(Component comp, java.lang.Object cntrnts) {}
//
//	@Override
//	@Deprecated
//	public void add(Component comp, java.lang.Object cntrnts, int ind) {}

}
