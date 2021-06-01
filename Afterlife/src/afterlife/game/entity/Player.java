package afterlife.game.entity;
/* Summary:
 * Holds the code for the player
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import afterlife.game.gamestate.GameState;
import afterlife.game.main.GamePanel;
import afterlife.game.object.Block;
import afterlife.game.physic.Collision;

public class Player extends Rectangle {
	
	//Movement booleans
	private boolean right = false, left = false, jumping = false, falling = false;
	private boolean topCollision = false;
	
	// Location / size
	private double x, y;
	private int width, height;
	
	// Move speed
	private double moveSpeed = 2.5;
	
	// Jump speed
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	
	// Fall speed
	private double maxFallSpeed  = 0.1;
	private double currentFallSpeed = 0.001;
	
	
	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}
	
	public void tick(Block[] b) {
		
		// Collision 
		for (Block currentB : b) {
			
			// Right
			if (Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + (int) GameState.yOffset + 2), currentB) || 
				Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset - 1), currentB)) {
					right = false;
					GameState.xOffset--;
				}
			
			// Left
			if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + (int) GameState.yOffset + 2), currentB) || 
				Collision.playerBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + height + (int) GameState.yOffset - 1), currentB)) {
					left = false;
					GameState.xOffset++;
			}
			
			// Top
			if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset + 1, (int) y + (int) GameState.yOffset), currentB) || 
				Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 1, (int) y + (int) GameState.yOffset), currentB)) {
					y = currentB.getY() - (int) GameState.yOffset;
					jumping = false;
					falling = true;
			}
			
			// Bottom
			
			if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset + 1), currentB) || 
				Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 1, (int) y + height + (int) GameState.yOffset + 1), currentB)) {
					falling = false;
					topCollision = true;
					System.out.print("b");
			} else if (!topCollision && !jumping) {
					falling = true;
					System.out.print("c");
			} 
		} 
		
		topCollision = false;
		
		// Movement for player
		// !!! The movement right now is bugged because when you press, it just flies off
		if (right) {
			GameState.xOffset += moveSpeed;
			right = false;
		} 
		
		if (left) {
			GameState.xOffset -= moveSpeed;
			left = false;
		}
		
		// Jumping 
		if (jumping) {
			System.out.print("b");
			GameState.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			
			System.out.print("b");
			
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		
		if (falling) {
			GameState.yOffset += currentFallSpeed;
			
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.000001;
			}
		}
		
		if (!falling) {
			currentFallSpeed = 0.001;
		}
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D) right = true;
		if (k == KeyEvent.VK_A) left = true;
		if (k == KeyEvent.VK_SPACE && !jumping && !falling) jumping = true;	// To add double-jumping, removing !jumping and !falling
	}
	
	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D) {
			right = false;
		}
		if (k == KeyEvent.VK_A) left = false;	

	}
	
}
