package afterlife.game.gamestate;
import java.awt.Graphics;

/**
 * This is the abstract class as the framework for any of the gamestate
 */

public abstract class GameState {
	protected GameStateManager gsm;
	public static double xOffset, yOffset;	// Represents how much the map needs to be shifted as the player moves
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		
		this.xOffset = 0;
		this.yOffset = 0;
		
		init();
	}
	
	/**
	 * Represents the initial creation of the gamestate
	 */
	public abstract void init();
	
	/**
	 * Updates the gamestate per tick
	 */
	public abstract void tick();
	
	
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
