package macstevins.game.test1.core.window;

import java.awt.Dimension;

import javax.swing.JFrame;

import macstevins.game.test1.core.io.KeyHandler;
import macstevins.game.test1.core.world.World;

@SuppressWarnings("unused")
public class Window extends JFrame {

	private static final long serialVersionUID = 7297748193968790346L;

	protected KeyHandler kh = new KeyHandler(this);

	private Dimension size;
	private World wlrd;

	public Window(Dimension size) {
		
		getContentPane().setPreferredSize(this.size = size);
		addKeyListener(kh);
		setDefaultCloseOperation(3);
		setLayout(null);
	
	}

	public Window addWorld(World wrld) {
		
		add(this.wlrd = wrld);
		return this;
	
	}

	public void initWindow() {
		
		pack();
		setLocationRelativeTo(null);
		super.setVisible(true);
	
	}

	@Override
	@Deprecated
	public void setVisible(boolean b) {}

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
//	public void add(Component comp, Object cntrnts) {}
//
//	@Override
//	@Deprecated
//	public void add(Component comp, Object cntrnts, int ind) {}

}
