package afterlife.game.gamestate;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import afterlife.game.entity.Player;
import afterlife.game.main.GamePanel;
import afterlife.game.main.Music;
import afterlife.game.mapping.Map;
import afterlife.game.object.Block;

public class Level1State extends GameState{
	
	private Player player;
	private Map map;
	
	Music music = new Music("sound/sad-music.wav", true);
	Music ambient1 = new Music("sound/wind.wav", true);
	Music ambient2 = new Music("sound/autumn-wind.wav", false);
	
	public Level1State(GameStateManager gsm) {
		super(gsm);
		
		try {
			music.play();
			//ambient1.play();
			ambient2.play();
		} catch (NullPointerException e) {
			System.out.println(e);
		}

	}

	@Override
	public void init() {
		player = new Player(30, 30);
		map = new Map("/Maps/map1.map");
		
		xOffset = -200;
		yOffset =  -400;
		
	}

	public void tick() {
		player.tick(map.getBlock(), map.getMovingBlocks());
		
		
	}

	public void draw(Graphics g) {
		g.setColor(new Color(50, 70, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
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
