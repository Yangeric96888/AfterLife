package afterlife.game.gamestate;
import java.awt.Graphics;

import afterlife.game.entity.Player;

public class Level1State extends GameState{
	
	private Player player;
	
	public Level1State(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		player = new Player(30, 30);
		
	}

	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
		
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
