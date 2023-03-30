import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GameWindow extends JFrame{
	
	public static JPanel topPanel;
	public static JPanel middlePanel;
	public final JPanel bottomPanel;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	
	public GameWindow() {
		
		middlePanel = new MiddlePanel();
		add(middlePanel, BorderLayout.CENTER);
	
		topPanel = new TopPanel((MiddlePanel) middlePanel);
		add(topPanel, BorderLayout.NORTH);
		bottomPanel = new BottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		
		
		setTitle("Pong");
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		BottomPanel.playPauseButton();

		
		while(MiddlePanel.getLive() >= 0) {
			
			if(MiddlePanel.getLive() > 0 ) {
				
				TopPanel.addScore();
				TopPanel.addLevel();
			}
			TopPanel.addLive();
			repaint();
		}	
	}
	
}


