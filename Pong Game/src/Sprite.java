import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Sprite {
	
	private double x;
	private double y;
	private int height;
	private int width;
	private Image image;
	

	
	public Sprite(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	
	public Sprite(Double x, Double y, int width, int height) {
		this(x,y);
		this.width = width;
		this.height = height;
	}
	

	public Image getImage() {
		return this.image;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

	public abstract void move();
}
