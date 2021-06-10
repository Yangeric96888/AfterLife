package afterlife.game.gamestate;
import java.awt.Graphics;
import java.util.Stack;

/**
 * This class handles the collection of GameStates
 * <p>
 * The active gamestate is always on the top of the stack
 * </p>
 * <p>
 * If the player goes to a new game state, it is added to the stack
 * </p>
 */

public class GameStateManager {
	
	public Stack<GameState> states;
	
	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MenuState(this));
	}
	
	public void tick() {
		states.peek().tick();
	}
	
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}
}
