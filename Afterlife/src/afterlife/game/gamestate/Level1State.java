package afterlife.game.gamestate;
import java.awt.Color;
import java.awt.Graphics;

import afterlife.game.entity.Player;
import afterlife.game.main.GamePanel;
import afterlife.game.mapping.Map;
import afterlife.game.object.Block;

public class Level1State extends GameState{
	
	private Player player;
	private Map map;

	
	public Level1State(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		player = new Player(30, 30);
		map = new Map("/Maps/map1.map");
		
		xOffset = -200;
		yOffset = -400;

	}

	public void tick() {
		player.tick(map.getBlock(), map.getMovingBlocks());
	}

	public void draw(Graphics g) {
		player.draw(g);
		map.draw(g);
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
