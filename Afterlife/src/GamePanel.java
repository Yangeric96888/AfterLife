import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 550;
	
	private Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		start();
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/*
	 * ******************************
	 * MAIN GAME LOOP
	 * ******************************
	 */
	
	public void run() {
		while(isRunning) {
			long start, elapsed, wait;
			start = System.nanoTime();
			
			tick();
			repaint();
			
			// Establishes set FPS; if the computer is too fast, we automatically slow it down
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 10000000;
			
			if (wait < 0) {
				wait = 5;
			}
			
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tick() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	/*
	 * ******************************
	 * KEY INPUTS
	 * ******************************
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
