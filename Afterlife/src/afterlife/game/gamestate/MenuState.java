package afterlife.game.gamestate;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import afterlife.game.main.GamePanel;
import afterlife.game.main.Music;

/**
 * This is the code for the menu
 */

public class MenuState extends GameState {
	
	Music help = new Music("sound/help.wav", false);
	
	private String[] options = {"Start", "Help", "Quit"};	// Contains all of the potential buttons
	private int currentSelection = 0;	// Represents what button the player is on
	
	protected MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
	}

	@Override
	public void tick() {
	}

	@Override
	public void draw(Graphics g) {
		// Set background
		g.setColor(new Color(50, 70, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// Draws the buttons
		for (int i = 0; i < options.length; i++) {
			// Currently selected
			if (i == currentSelection) {
				g.setColor(Color.green);
			// Not currently selected
			} else {
				g.setColor(Color.white);
			}
			
			// g.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT);
			g.setFont(new Font("Arial", Font.PLAIN, 72));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 75, 150 + i * 150);
		}
		
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN) {
			currentSelection++;
			if (currentSelection >= options.length) {
				currentSelection = 0;
			}
		} else if (k == KeyEvent.VK_UP) {
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		// Occurs when player picks a button
		if (k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) {
				gsm.states.push(new Level1State(gsm));
			} else if (currentSelection == 1) {
				help.play();
			} else if (currentSelection == 2) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {		
	}

}
