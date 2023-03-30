import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle extends Sprite {
	
	private static int paddleWidth = 120;
	private static int paddleHeight = 10;
	private static int paddleSpeed = 0;
	private static double paddleLocationX = 440;
	private static double paddlelocationY = 600;
	
	public Paddle(int x, int y, int width, int height) {
		super(paddleLocationX, paddlelocationY, paddleWidth, paddleHeight);		
	}
	
	
	@Override
	public double getX() {
		return paddleLocationX;
	}
	
	@Override
	public double getY() {
		return paddlelocationY;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int) (paddleLocationX), (int) (paddlelocationY), paddleWidth, paddleHeight);
	}
	
	@Override 
	public void move() {
		paddleLocationX += paddleSpeed;
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddleSpeed = -30;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddleSpeed = +30;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddleSpeed = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddleSpeed = 0;
		}
	}
	
	public void setPaddleX(int x) {
		paddleLocationX = x;
	}
	
	public int getPaddleWidth() {
		return paddleWidth;
	}
	
	public int getPaddleHeigt() {
		return paddleHeight;
	}
}
