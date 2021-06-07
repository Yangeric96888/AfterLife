package afterlife.game.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import afterlife.game.gamestate.GameState;
import afterlife.game.resources.Images;

public class Block extends Rectangle {
	
	public static int blockSize = 64;
	private int id;
	
	public Block(int x, int y, int id) {
		setBounds(x, y, blockSize, blockSize);
		this.id = id;
	}	
	
	public void tick() {

	}
	
	public void draw(Graphics g) {
		// Does not work for some reason g.fillRect(x - (int) GameState.xOffset, y - (int) GameState.yOffset, blockSize, blockSize);
		g.setColor(Color.black);
		if(id != 0) {
			g.drawImage(Images.blocks[id - 1],x - (int) GameState.xOffset, y   - (int) GameState.yOffset , blockSize, blockSize, null);
		}

	}
	
	// getters and setters
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
}
