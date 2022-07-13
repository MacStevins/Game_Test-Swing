package macstevins.game.test1.core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import macstevins.game.test1.core.io.Settings;
import macstevins.game.test1.core.window.SettingsDialog;
import macstevins.game.test1.core.window.Window;
import macstevins.game.test1.core.world.Object;
import macstevins.game.test1.core.world.Player;

public class TheGame extends Window implements Runnable {

	private static final long serialVersionUID = -1654731205283642989L;

	//World
//	private double grav = 9.80665;
	private Component[] comps;

	//Player
	private static Player plr;
	private int plrSpeed = 25, plrX, plrY, fps;
	private Dimension plrSize = new Dimension(25, 25);

	public TheGame() { super(new Dimension(500, 500)); }

	public void init() {
		
		new SettingsDialog();
		
		System.out.println(getContentPane().getPreferredSize());
		
		add(plr = new Player(Color.gray, new Dimension(25, 25), new Point(getContentPane().getPreferredSize().width / 2, getContentPane().getPreferredSize().height / 2)));
		plrX = plr.getX();
		plrY = plr.getY();
		
		//, new Point(200, 450)
		//, new Dimension(100, 10)
		Point[] objLoc      = new Point[]     {new Point(150, 300),    new Point(213, 188),   new Point(263, 188),   new Point(50, 100),   new Point(98, 53),   new Point(350, 200),   new Point(350, 250),   new Point(200, 450),       new Point(500, 500),   new Point(520, 500),   new Point(500, 520)};
		Dimension[] objSize = new Dimension[] {new Dimension(50, 100), new Dimension(25, 25), new Dimension(25, 25), new Dimension(100, 5), new Dimension(5, 100), new Dimension(25, 25), new Dimension(25, 25), new Dimension(100, 10), new Dimension(10, 10), new Dimension(10, 10), new Dimension(30, 10)};
		
		for(int a = 0; a < (objLoc.length | objSize.length); a++) add(new Object(Color.black, objSize[a], objLoc[a]));
		
		initWindow();
		
		loadMoveThrd();
		loadRendThrd();
		
//		Thread.sleep(250);
//		loadGravThrd();
	
	}

	void loadMoveThrd() {
		
		((ScheduledExecutorService) Executors.newSingleThreadScheduledExecutor()).scheduleAtFixedRate(new Runnable() {
		
			@Override
			public void run() {
				
				if(kh.isKeyPressed(Settings.upKey)) {
					
					plrY -= 1;
					collisDetect(1);
				
				}
				if(kh.isKeyPressed(Settings.lfKey)) {
					
					plrX -= 1;
					collisDetect(2);
				
				}
				if(kh.isKeyPressed(Settings.dnKey)) {
					
					plrY += 1;
					collisDetect(3);
				
				}
				if(kh.isKeyPressed(Settings.rtKey)) {
					
					plrX += 1;
					collisDetect(4);
				
				}
				
				setTitle("x: " + plrX + ", y: " + plrY + ", FPS: " + fps);
			
			}
		
		}, 0, 100 / plrSpeed, TimeUnit.MILLISECONDS);
	
	}

	void loadGravThrd() {
		
//		mils = System.currentTimeMillis();
//		((ScheduledExecutorService) Executors.newSingleThreadScheduledExecutor()).scheduleAtFixedRate(new Runnable() {
//		
//			@Override
//			public void run() {
//				
//				velDn = (int) Math.floor(grav * (System.currentTimeMillis() - mils) / 1000);
//				plrY += velDn;
//			
//			}
//		
//		}, 0, 10, TimeUnit.MILLISECONDS);
	
	}

	void loadRendThrd() {
		
		new Thread(new Runnable() {
		
			@Override
			public void run() {
				
				try {
					
					double time = System.nanoTime() / 1000000000.0, time2, second_pass = 0;
					int frames = 0;
					
					while(true) {
						
						second_pass += (time2 = System.nanoTime() / 1000000000.0) - time;
						
						plr.setLocation(plrX, plrY);
						
						if(second_pass >= 1.0) {
							
							System.out.println("FPS: " + (fps = frames) + ", Frame Time: " + ((time2 * 1000) - (time * 1000)));
							second_pass = 0;
							frames = 0;
						
						}
						frames++;
						time = time2;
						
						if(Settings.fps > 0) TimeUnit.NANOSECONDS.sleep((long) (1000000000.0 / Settings.fps));
					
					}
				
				}
				catch(Exception e) { e.printStackTrace(); }
			
			}
		
		}).start();
	
	}

	void collisDetect(int side) {
		
		comps = getContentPane().getComponents();
		for(int a = 0; a < comps.length; a++) {
			
			if(comps[a] instanceof Object) {
				
				if(plrY + plrSize.height < comps[a].getY() + 1 || plrY > comps[a].getY() + comps[a].getHeight() - 1 || plrX > comps[a].getX() + comps[a].getWidth() - 1 || plrX + plrSize.width < comps[a].getX() + 1) continue;
				
				if(side == 1 && plrY + plrSize.height > comps[a].getY() + 1) plrY++;
				if(side == 2 && plrX + plrSize.width > comps[a].getX() + 1) plrX++;
				if(side == 3 && plrY < comps[a].getY() + comps[a].getHeight() - 1) plrY--;
				if(side == 4 && plrX < comps[a].getX() + comps[a].getWidth() - 1) plrX--;
			
			}
		
		}
	
	}

	@Override public void run() { init(); }

}
