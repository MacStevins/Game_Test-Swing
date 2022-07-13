package macstevins.game.test1.core.window;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;

import macstevins.game.test1.core.io.*;

public class SettingsDialog extends JDialog {

	private static final long serialVersionUID = 6025590532086173270L;

	public SettingsDialog() {
		
		File file = new File("settings.txt");
		initFile(file);
		
		getRootPane().setPreferredSize(new Dimension(305, 85));
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		setResizable(false);
		setDefaultCloseOperation(0);
		setTitle("Framerate: " + Settings.fps);
		
		JTextField tfKeys  = new JTextField(10);
		JSlider sldrFPS = new JSlider(0, 0, 48, Settings.fps / 5);
		JButton btnChng = new JButton("Change Keys");
		
		sldrFPS.addChangeListener(new ChangeListener() {
		
			@Override
			public void stateChanged(ChangeEvent e) {
				
				setTitle("Framerate: " + (Settings.fps = ((JSlider) e.getSource()).getValue() * 5));
				writeFile(file);
			
			}
		
		});
		
		btnChng.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new KeyChangeDialog("Change Keys", ModalityType.APPLICATION_MODAL);
				writeFile(file);
			
			}
		
		});
		btnChng.setPreferredSize(new Dimension(110, 25));
		
		tfKeys.setEditable(false);
		
		add(new JLabel("Framerate:"));
		add(sldrFPS);
		add(btnChng);
//		add(tfKeys);
		
		pack();
		setLocationRelativeTo(null);
		setLocation(getX() + 450, getY());
		setVisible(true);
	
	}

	private void initFile(File file) {
		
		try {
			
			if(!file.exists()) {
				
				file.createNewFile();
				writeFile(file);
			
			}
			else {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line;
				while((line = reader.readLine()) != null) {
					
					String values = line.split(":")[1];
					
					switch (line.split(":")[0]) {
						
						case "game.fps": {
							Settings.fps = Integer.parseInt(line.split(":")[1]);
							break;
						}
						case "key.Up": {
							Settings.upKey = Integer.parseInt(line.split(":")[1]);
							break;
						}
						case "key.Left": {
							Settings.lfKey = Integer.parseInt(line.split(":")[1]);
							break;
						}
						case "key.Down": {
							Settings.dnKey = Integer.parseInt(line.split(":")[1]);
							break;
						}
						case "key.Right": {
							Settings.rtKey = Integer.parseInt(line.split(":")[1]);
							break;
						}
					
					}
				
				}
			
			}
		
		}
		catch(Exception e) { e.printStackTrace(); }
	
	}

	private void writeFile(File file) {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("game.fps:" + Settings.fps    + "\n");
			
			writer.write("key.Up:"    + Settings.upKey + "\n");
			writer.write("key.Left:"  + Settings.lfKey + "\n");
			writer.write("key.Down:"  + Settings.dnKey + "\n");
			writer.write("key.Right:" + Settings.rtKey);
			
			writer.close();
		
		}
		catch(Exception e) { e.printStackTrace(); }
	
	}

}
