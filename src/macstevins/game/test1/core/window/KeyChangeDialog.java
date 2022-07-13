package macstevins.game.test1.core.window;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import macstevins.game.test1.core.io.Settings;

public class KeyChangeDialog extends JDialog {

	private static final long serialVersionUID = 2286789727244398740L;

	public KeyChangeDialog(String title, ModalityType mode) {
		
		super(null, title, mode);
		
		getRootPane().setPreferredSize(new Dimension(150, 150));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setResizable(false);
		
		JTextField tfUpKey = new JTextField(KeyEvent.getKeyText(Settings.upKey));
		JTextField tfLfKey = new JTextField(KeyEvent.getKeyText(Settings.lfKey));
		JTextField tfDnKey = new JTextField(KeyEvent.getKeyText(Settings.dnKey));
		JTextField tfRtKey = new JTextField(KeyEvent.getKeyText(Settings.rtKey));
		
		tfUpKey.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent e) { ((JTextField) e.getSource()).setText(KeyEvent.getKeyText(Settings.upKey = e.getKeyCode())); }
			@Override public void keyTyped(KeyEvent e) { e.consume(); }
		});
		tfLfKey.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent e) { ((JTextField) e.getSource()).setText(KeyEvent.getKeyText(Settings.lfKey = e.getKeyCode())); }
			@Override public void keyTyped(KeyEvent e) { e.consume(); }
		});
		tfDnKey.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent e) { ((JTextField) e.getSource()).setText(KeyEvent.getKeyText(Settings.dnKey = e.getKeyCode())); }
			@Override public void keyTyped(KeyEvent e) { e.consume(); }
		});
		tfRtKey.addKeyListener(new KeyAdapter() {
			@Override public void keyPressed(KeyEvent e) { ((JTextField) e.getSource()).setText(KeyEvent.getKeyText(Settings.rtKey = e.getKeyCode())); }
			@Override public void keyTyped(KeyEvent e) { e.consume(); }
		});
		
		add(new JLabel("Up Key:"));
		add(tfUpKey);
		add(new JLabel("Left Key:"));
		add(tfLfKey);
		add(new JLabel("Down Key:"));
		add(tfDnKey);
		add(new JLabel("Right Key:"));
		add(tfRtKey);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	}

}
