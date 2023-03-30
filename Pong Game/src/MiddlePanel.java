import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class MiddlePanel extends JPanel implements Runnable {
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(600);
	static final Dimension PANEL_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	static Ball ball;
	Paddle paddle;
	Rectangle ballRectangle;
	Rectangle paddleRectangle;
	private static int score = 0;
	private static int live = 3;
	private static boolean isGameOver = false;
	
	
	MiddlePanel(){
		ball = new Ball(GAME_HEIGHT, GAME_HEIGHT, GAME_WIDTH, GAME_HEIGHT);
		paddle = new Paddle(GAME_HEIGHT, GAME_HEIGHT, GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.setPreferredSize(PANEL_SIZE);
		this.addKeyListener(new inputListener());
		gameThread = new Thread(this);
		gameThread.start();	
	}

	
	@Override
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		ball.draw(g);
		paddle.draw(g);
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				isGameOver();
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}	
	}
	
	public void move() {
		ball.move();
		System.out.println(paddle.getX());
		paddle.move();
	}
	
	public void checkCollision() {
		if(ball.getY() <= 0) {
			ball.setBallSpeedY(-ball.getBallSpeedY());
		}
		
		if(ball.getX() <= paddle.getX() + paddle.getPaddleWidth() && ball.getX() >= paddle.getX()) {
			if(ball.getY() - ball.getBallRadius() >= paddle.getY() && ball.getY() <= paddle.getY() + paddle.getPaddleHeigt()+ 40) {
				if(ball.getY() >= paddle.getY() + paddle.getPaddleHeigt() + 35) {
					ball.setBallSpeedY(-ball.getBallSpeedY() - 0.24);
				}else {
					ball.setBallY(paddle.getY());
					ball.setBallSpeedY(-ball.getBallSpeedY());
				}
				MiddlePanel.score++;
			}
		}
		
		
		if(ball.getY() > 800) {
			live--;
			ball.resetPosition(TopPanel.getLevel());	
		}	
		
		if(ball.getX() <= 0) {
			ball.setBallSpeedX(-ball.getBallSpeedX());
		}
		if(ball.getX() >= GAME_WIDTH - ball.getBallRadius()) {
			ball.setBallSpeedX(-ball.getBallSpeedX());
		}
		
		if(paddle.getX() <= 0) {
			paddle.setPaddleX(0);
		}
		if(paddle.getX() >= this.getWidth() - paddle.getPaddleWidth()) {
			paddle.setPaddleX(this.getWidth() - paddle.getPaddleWidth());
		}	
	}
	
	public class inputListener extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
		}	
	}

	public static int getScore() {
		return MiddlePanel.score;
	}
	
	public static int getLive() {
		return MiddlePanel.live;
	}
	
	public static boolean isGameOver() {
		if(live <= 0) {
			gameThread.stop();
			return true;
		}	
		return false;
	}	
}
	
