import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 550;
	
	public GamePanel() {
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
	}
}
