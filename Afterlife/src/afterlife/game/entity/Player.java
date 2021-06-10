package afterlife.game.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import afterlife.game.gamestate.GameState;
import afterlife.game.main.GamePanel;
import afterlife.game.main.Music;
import afterlife.game.object.Block;
import afterlife.game.object.MovingBlock;
import afterlife.game.physic.Collision;

/**
 * This class represents the player along with its map collisions and movement
 * <p>
 * Up-down movement is represented by jumping and (after hitting the top of jump) falling.
 * </p>
 * <p>
 * Movement is represented by relatively moving the map (not the character)
 * </p>
 * 
 */

public class Player extends Rectangle {
	
	// Sound
	Music respawn = new Music("sound/guitar.wav", false);
	
	// Movement 
	private boolean right = false, left = false, jumping = false, falling = false;
	private boolean topCollision = false;

	// Location / size
	private double x, y;
	private int width, height;

	// Move speed
	private double moveSpeed = 5.5;

	// Jump speed
	private double jumpSpeed = 0.003;
	private double currentJumpSpeed = jumpSpeed;

	// Fall speed
	private double maxFallSpeed = 0.003;
	private double currentFallSpeed = 0.00001;
	private double acceleration = (0.0000005/15);
	
	// Constructor
	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width; 
		this.height = height;
	}
	
	/**
	 * @param b - 2d array of all of the blocks in the map
	 * @param movBlocks - arraylist of all movingblocks
	 */
	public void tick(Block[][] b, ArrayList<MovingBlock> movingBlocks) {

		/*
		 * ===================================================================
		 * COLLISION
		 * Cycles through all blocks and checks if they collide with the player!
		 * ===================================================================
		 */
		
		for (Block[] currentBlockRow : b) {

			for (Block currentB : currentBlockRow) {
				if (currentB.getID() != 0) {
					
					// Right
					if (Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + (int) GameState.yOffset + 2), currentB)
							|| Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset - 1), currentB)) {
						right = false;
						GameState.xOffset--;
					}
					
					// Left
					if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + (int) GameState.yOffset + 2), currentB)
							|| Collision.playerBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + height + (int) GameState.yOffset - 1), currentB)) {
						left = false;
						GameState.xOffset++;
					}

					// Top
					if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset + 1, (int) y + (int) GameState.yOffset), currentB)
							|| Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 2, (int) y + (int) GameState.yOffset), currentB)) {					
						jumping = false;
						falling = true;
					}

					// Bottom
					if (Collision.playerBlock(new Point((int) x + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset + 1), currentB)
							|| Collision.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 2, (int) y + height + (int) GameState.yOffset + 1), currentB)) {
						falling = false;
						topCollision = true;
					} else if (!topCollision && !jumping) {
						falling = true;
					}
				}
			}
			
		}
		
		for(int i = 0; i < movingBlocks.size(); i++) {
			if(movingBlocks.get(i).getID() != 0) {

				// Right
				if (Collision.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + (int) GameState.yOffset + 2), movingBlocks.get(i))
						|| Collision.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset - 1), movingBlocks.get(i))) {
					right = false;
					GameState.xOffset--;
				}

				// Left
				if (Collision.playerMovingBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + (int) GameState.yOffset + 2), movingBlocks.get(i))
						|| Collision.playerMovingBlock(new Point((int) x + (int) GameState.xOffset - 1, (int) y + height + (int) GameState.yOffset - 1), movingBlocks.get(i))) {
					left = false;
					GameState.xOffset++;
				}
				
				// Top
				if (Collision.playerMovingBlock(new Point((int) x + (int) GameState.xOffset + 1, (int) y + (int) GameState.yOffset), movingBlocks.get(i))
						|| Collision.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset - 2, (int) y + (int) GameState.yOffset), movingBlocks.get(i))) {					
					jumping = false;
					falling = true;
				}

				// Bottom
				if (Collision.playerMovingBlock(new Point((int) x + (int) GameState.xOffset + 2, (int) y + height + (int) GameState.yOffset + 1), movingBlocks.get(i))
						|| Collision.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset - 2, (int) y + height + (int) GameState.yOffset + 1), movingBlocks.get(i))) {
					falling = false;
					topCollision = true;
					
					// moves the Player with the MovingBlock
					GameState.xOffset += movingBlocks.get(i).getMove();
					
				} else if (!topCollision && !jumping) {
					falling = true;
				}
			}
		}

		topCollision = false;

		/*
		 * ===================================================================
		 * MOVEMENT
		 * ===================================================================
		 */
		
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
			GameState.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= acceleration;
			

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		
		// Falling
		if (falling) {
			GameState.yOffset += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += acceleration;
			}
		}
		
		// Not falling
		if (!falling) {
			currentFallSpeed = 0.0001;
		}
	}
	
	/*
	 * ===================================================================
	 * DRAWING AND KEY INPUTS
	 * ===================================================================
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	// Handles jump, moving left/right
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_RIGHT)
			right = true;
		if (k == KeyEvent.VK_LEFT)
			left = true;
		if (k == KeyEvent.VK_UP && !jumping && !falling ) {
			jumping = true; // To add double-jumping, removing !jumping and !falling	
		}	
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (k == KeyEvent.VK_LEFT)
			left = false;
	}
}
