package afterlife.game.entity;
/* Summary:
 * Holds the code for the player
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import afterlife.game.main.GamePanel;

public class Player extends Rectangle {
	
	//Movement booleans
	private boolean right = false, left = false, jumping = false, falling = false;
	
	// Location / size
	private double x, y;
	private int width, height;
	
	// Jump speed
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	
	// Fall speed
	private double maxFallSpeed  = 5;
	private double currentFallSpeed = 0.1;
	
	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		
		// Movement for player
		if (right) {
			x += 10;
			right = false;
		} 
		
		if (left) {
			x--;
		}
		
		if (jumping) {
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		
		if (falling) {
			y += currentFallSpeed;
			
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.1;
			}
		}
		
		if (!falling) {
			currentFallSpeed = 0.1;
		}
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D) right = true;
		if (k == KeyEvent.VK_A) left = true;
		if (k == KeyEvent.VK_SPACE) jumping = true;
	}
	
	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D) right = false;
		if (k == KeyEvent.VK_A) left = false;		
	}
	
}
