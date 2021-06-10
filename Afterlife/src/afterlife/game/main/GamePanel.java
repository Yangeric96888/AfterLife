package afterlife.game.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import afterlife.game.gamestate.GameStateManager;
import afterlife.game.resources.Images;

/**
 * Technical code behind running the game itself
 * <p>
 * Handles FPS, game loop, and painting
 * </p>
 * <p>
 * Calls on the GameState Manager to handle other aspects of the code (ticking, gamestates)
 * </p>
 */

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	// Frame size
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	// Gameloop variables
	private Thread thread;
	private boolean isRunning = false;
	
	// FPS
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	private GameStateManager gsm;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		
		new Images();
		
		start();
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/*
	 * ===================================================================
	 * MAIN GAME LOOP
	 * ===================================================================
	 */
	
	public void run() {
		
		gsm = new GameStateManager();
		
		while(isRunning) {
			long start, elapsed, wait;
			start = System.nanoTime();
			
			tick();
			repaint();
			
			// Establishes set FPS; if the computer is too fast, we automatically slow it down
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 100000000;
			
			if (wait < 0) {
				wait = 5;
			}
			
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * ===================================================================
	 * TICK/PAINT/KEY INPUTS
	 * Passes them onto the gamestate Manager
	 * ===================================================================
	 */
	
	public void tick() {
		gsm.tick();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		gsm.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}
	
}
