package afterlife.game.resources;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Handles the technicalities behind loading in images as blocks
 */

public class Images {
	
	public static BufferedImage[] blocks;
	
	public Images() {
		blocks = new BufferedImage[1];
		try {
		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/block_brick.png"));
//		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/cobblestone_mossy.png"));
//		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/dark_prismarine.png"));
//		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/farmland_moist.png"));
//		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/glass_magenta.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
