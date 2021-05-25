package afterlife.game.physic;

import java.awt.Point;

import afterlife.game.object.Block;

public class Collision {
	
	// Returns if a point is inside a block
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p);
	}
}
