package macstevins.game.test1.core.io;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import macstevins.game.test1.core.window.Window;

public class KeyHandler extends KeyAdapter {

	private static boolean[] keys = new boolean[65536];

	static { for(int a = 0; a < keys.length; a++) keys[a] = false; }

	public KeyHandler(Window win) { win.addWindowFocusListener(new WindowAdapter() { @Override public void windowLostFocus(WindowEvent e) { for(int a = 0; a < keys.length; a++) keys[a] = false; } }); }

	public boolean isKeyPressed(int key) { return keys[key]; }

	@Override public void keyPressed(KeyEvent e) { keys[e.getKeyCode()] = true; }

	@Override public void keyReleased(KeyEvent e) { keys[e.getKeyCode()] = false; }

}
