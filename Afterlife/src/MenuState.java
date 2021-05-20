import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private String[] options = {"Start", "Help", "Quit"};
	private int currentSelection = 0;
	
	protected MenuState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		
		// Set background
		g.setColor(new Color(50, 70, 200));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// Draws the buttons
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.green);
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
		
		// When players picks a button
		if (k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) {
				
			} else if (currentSelection == 1) {
				
			} else if (currentSelection == 2) {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {

		
	}

}
