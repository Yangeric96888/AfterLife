package afterlife.game.mapping;

import java.awt.Graphics;

import afterlife.game.object.Block;

public class Map {
	
	private String path;
	private int width, height;
	private Block[][] blocks;
	
	public Map(String loadPath, int width, int height) {
		path = loadPath;
		this.width = width;
		this.height = height;
		
		blocks = new Block[height][width];
		
		for (int i = 0; i < blocks.length; i++) {
			for (int ii = 0; ii < blocks[i].length; ii++) {
				blocks[i][ii] = new Block(ii * Block.blockSize, i * Block.blockSize);
			}
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < blocks.length; i++) {
			for (int ii = 0; ii < blocks[i].length; ii++) {
				blocks[i][ii].draw(g);
			}
		}
	}
	
	public Block[][] getBlock() {
		return blocks;
	}
}
