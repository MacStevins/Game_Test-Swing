package macstevins.game.test1;

import javax.swing.SwingUtilities;

import macstevins.game.test1.core.TheGame;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Hello, World!\n");
		SwingUtilities.invokeLater(new TheGame());
	
	}

}
