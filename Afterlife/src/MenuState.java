import java.awt.Color;
import java.awt.Graphics;

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
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.green);
			} else {
				g.setColor(Color.black);
			}
			
			g.drawString(options[i], GamePanel.WIDTH / 2 - 50, 50 + i * 30);
		}
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
