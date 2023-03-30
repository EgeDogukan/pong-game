import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	
	static JButton playPauseButton;
	private static boolean isClicked = false;
	
	
	
	
	public BottomPanel() {	
		playPauseButton = new JButton("Play/Pause");
		add(playPauseButton);
	}
	
	public static void playPauseButton() {
		playPauseButton.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(isClicked == true) {
						MiddlePanel.gameThread.start();
						isClicked = false;
					}
					if(isClicked == false) {
						MiddlePanel.gameThread.stop();
						isClicked = true;
					}
				}
			});
	}
}
