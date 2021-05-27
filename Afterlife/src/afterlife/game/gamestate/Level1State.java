package afterlife.game.gamestate;
import java.awt.Graphics;

import afterlife.game.entity.Player;
import afterlife.game.object.Block;

public class Level1State extends GameState{
	
	private Player player;
	
	private Block[] b;
	
	public Level1State(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		player = new Player(30, 30);
		
		b = new Block[3];
		
		b[0] = new Block (100, 100);
		b[1] = new Block (200, 200);
		b[2] = new Block (300, 300);
	}

	@Override
	public void tick() {
		for (Block currentB : b) {
			currentB.tick();
		}
		
		player.tick(b);
		
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
		
		for (Block currentB : b) {
			currentB.draw(g);
		}
	}

	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);
		
	}

	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);
		
	}

}
