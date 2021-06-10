package afterlife.game.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Contains the technical details on running the Java frame
 * <p> 
 * This is where the code is actually started from
 * </p>
 */

public class Frame extends JPanel {

	public void paint(Graphics g) {
		super.paint(g);	// Refresh the JFrame 
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		
		JFrame f = new JFrame("Afterlife");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(new BorderLayout());
		f.add(new GamePanel(), BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.setBackground(Color.blue);
		f.add(this);
		
	}
	
}
