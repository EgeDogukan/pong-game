import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JPanel;

public class Ball extends Sprite {
	
	private static final int BALL_RADIUS = 10;
	private static double ballSpeedX = 4;
	private static double ballSpeedY = 1;
	private static double ballLocationX = 10;
	private static double ballLocationY = 10;
	private static boolean GameOver = false;

	
	
	public Ball(int x, int y, int width, int height) {
		super(ballLocationX, ballLocationY, BALL_RADIUS, BALL_RADIUS);
	}

	@Override
	public void move() {
		ballLocationY = (ballLocationY - (ballSpeedY - 9.8 * 0.02));
		ballSpeedY = (ballSpeedY - 9.8 * 0.02);
		
		ballLocationX += ballSpeedX ;
	}
	
	@Override
	public double getX() {
		return ballLocationX;
	}
	
	@Override
	public double getY() {
		return ballLocationY;
	}
	
	public boolean IsGameOver() {
		return GameOver;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) (ballLocationX), (int) (ballLocationY), BALL_RADIUS, BALL_RADIUS);
	}
	
	public void setBallSpeedX(Double ballSpeedx) {
		Ball.ballSpeedX = ballSpeedx;
	}
	
	public void setBallSpeedY(Double ballSpeedy) {
		Ball.ballSpeedY = ballSpeedy;
	}
	
	public double getBallSpeedX() {
		return ballSpeedX;
	}
	
	public double getBallSpeedY() {
		return ballSpeedY;
	}
	
	public int getBallRadius() {
		return BALL_RADIUS;
	}
	
	public void setBallY(Double ballY) {
		Ball.ballLocationY = ballY;
	}

	public void resetPosition(int level) {
		Ball.ballLocationX = 10;
		Ball.ballLocationY = 10;
		Ball.ballSpeedY = 1;
		for(int i = 1; i <= level; i++) {
			if(i== 1) {
				continue;
			}else {
				ballSpeedY += ballSpeedY / 2;
			}
		}
	}
	
	public void resetPosition() {
		Ball.ballLocationX = 10;
		Ball.ballLocationY = 10;
		Ball.ballSpeedY = 0;
	}
}
