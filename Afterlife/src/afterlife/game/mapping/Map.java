package afterlife.game.mapping;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import afterlife.game.object.Block;
import afterlife.game.object.MovingBlock;

/**
 * Handles the technicalities behind loading in a map
 */

public class Map {
	
	private String path;
	private String line;
	
	private Block[][] blocks;
	private ArrayList<MovingBlock> movingBlocks;
	
	private int width, height;
	
	/**
	 * This is the Map class's constructor.
	 * It is responsible for using the input of the location and name of the map file
	 * and loading the desired map file.
	 */
	public Map(String loadPath) {
		path = loadPath;
		loadMap();
		
	}
	
	/**
	 * This is the method that paints the blocks
	 * by going through a 2D array of 0s and 1s representing air and blocks respectively.
	 */
	public void draw(Graphics g) {

		for (int i = 0; i < blocks.length; i++) {
			for (int ii = 0; ii < blocks[i].length; ii++) {
				blocks[i][ii].draw(g);
			}
		}
		
		for(int i = 0; i < movingBlocks.size(); i++) {
			movingBlocks.get(i).draw(g);
		}
		
	}
	
	/*
	 * Loads the map using an InputStream and BufferedReader
	 * It does this by going row by row in the text document and creating 1D arrays representing blocks or no blocks
	 * If the if of the element in the map is a 1 then a block is drawn.
	 */
	public void loadMap() {
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		try {
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());
			
			blocks = new Block[height][width];
			
			for(int y = 0; y < height; y++) {
				line = br.readLine();
				String[] tokens = line.split("\\s+");
				for(int x = 0; x < width; x++) {
					blocks[y][x] = new Block(x * Block.blockSize, y * Block.blockSize, Integer.parseInt(tokens[x]));
				}
			}
			
			line = br.readLine();
			line = br.readLine();
			int length = Integer.parseInt(line);
			movingBlocks = new ArrayList<MovingBlock>();
			
			for(int i = 0; i < length; i++) {
				line = br.readLine();
				String[] tokens = line.split("\\s+");
				
				movingBlocks.add(new MovingBlock(
						Integer.parseInt(tokens[0]) * Block.blockSize,  
						Integer.parseInt(tokens[1]) * Block.blockSize, 
						Integer.parseInt(tokens[2]), 
						Integer.parseInt(tokens[3]) * Block.blockSize, 
						Integer.parseInt(tokens[4]) * Block.blockSize));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * getter for 2D array of Blocks
	 */
	public Block[][] getBlock() {
		return blocks;
	}
	
	/**
	 * getter for ArrayList of MovingBlocks
	 */
	public ArrayList<MovingBlock> getMovingBlocks(){
		return movingBlocks;
	}
	
}
