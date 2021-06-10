package afterlife.game.object;
import java.awt.Graphics;
import java.awt.Rectangle;

import afterlife.game.gamestate.GameState;
import afterlife.game.resources.Images;

/**
 * Represents an individual moving block
 */

public class MovingBlock extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	private int leftBound, rightBound;
	private int move = 1;
	private int id;
	
	public MovingBlock(int x, int y, int id, int leftBound, int rightBound) {
		setBounds(x, y, Block.blockSize, Block.blockSize);
		this.id = id;
		this.rightBound = rightBound;
		this.leftBound = leftBound;
	}
	
	/*
	 * If the moving block hits the right end of its range, it moves left
	 * If the moving block hits the left end of its range, it moves right
	 */
	public void tick() {
		// right side of block has hit rightBound
		if(x + width - GameState.xOffset >= rightBound - GameState.xOffset && move != 1) {
			move *= -1;
		}
		// left side of the block has hit leftBound
		if(x - GameState.xOffset <= leftBound - GameState.xOffset && move != 1) {
			move *= -1;
		}
		
		x += move;
		
	}
	
	public void draw(Graphics g) {
		if(id != 0) {
			g.drawImage(Images.blocks[id - 1], x - (int)GameState.xOffset, y - (int)GameState.yOffset, width, height, null);
		}
	}
	
	public int getMove() {
		return move;
	}
	
	public int getID() {
		return id;
	}
	
}
