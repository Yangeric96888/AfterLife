package afterlife.game.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import afterlife.game.gamestate.GameState;

public class Block extends Rectangle {
	
	public static final int blockSize = 32;
	
	public Block(int x, int y) {
		setBounds(x, y, blockSize, blockSize);
	}
	
	public void tick() {

	}
	
	public void draw(Graphics g) {
		// Does not work for some reason g.fillRect(x - (int) GameState.xOffset, y - (int) GameState.yOffset, blockSize, blockSize);
		g.fillRect(x - (int) GameState.xOffset, y   - (int) GameState.yOffset , blockSize, blockSize);

	}
}
