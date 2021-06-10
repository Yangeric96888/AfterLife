package afterlife.game.physic;
import java.awt.Point;

import afterlife.game.object.Block;
import afterlife.game.object.MovingBlock;

/**
 * Contains the methods of collision between player and block
 */

public class Collision {
	
	/**
	 * Returns if a point on the players is inside the block
	 * @param p - A point on player
	 * @param b - A block
	 * @return whether or not p is inside b
	 */
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p);
	}
	
	/**
	 * Returns if a point on the players is inside the block
	 * @param p - A point on player
	 * @param b - A block
	 * @return whether or not p is inside b
	 */
	public static boolean playerMovingBlock(Point p, MovingBlock b) {
		return b.contains(p);
	}
	
}
