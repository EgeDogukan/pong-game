import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel implements ActionListener{
	
	static JLabel liveJLabel = new JLabel("Remaining Lives: 3");
	static JLabel scoreJLabel = new JLabel("Score: 0");
	static JLabel timeLabel = new JLabel("Time: 0");
	static MiddlePanel panel;
	static JLabel levelJLabel = new JLabel("Level: 1");
	private static javax.swing.Timer timer;
	private int time = 0;
	private static int level = 1;
	
	public TopPanel(MiddlePanel panel) {
		this.panel = panel;
		add(scoreJLabel);
		add(liveJLabel);
		add(timeLabel);
		add(levelJLabel);
		addTimer();
		repaint();
		setPreferredSize(new Dimension(1024, 50));
	}
	
	public static void addScore() {
		scoreJLabel.setText("Score: " + panel.getScore());
	}
	
	public static void addLive() {
		liveJLabel.setText("Remaining Lives: " + panel.getLive());
	}
	
	public void addTimer() {
		timer = new javax.swing.Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time++;
		if(time < 61) {
			timeLabel.setText("Time: " + time);
		}
		if(time >= 61) {
			timer.restart();
			time = 1;
			level++;
			panel.ball.resetPosition(level);
			repaint();
		}
		if(MiddlePanel.isGameOver() == true) {
			timer.stop();
		}
	}
	
	public static void addLevel() {
		levelJLabel.setText("Level: " + level);
	}
	
	public static int getLevel() {
		return level;
	}
}
