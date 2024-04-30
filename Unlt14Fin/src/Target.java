import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Target {
	private int x,y;
	private int radius;
	BufferedImage img;


	public Target(int x, int y, int radius, String imgPath) throws IOException {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.img = ImageIO.read(new File(imgPath));
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	public boolean isInside(int a, int b) {
		//hitBox Strategy
		int left = x;
		int right = x + 2* radius; 
		int top = y;
		int bottom = y + 2 * radius;
		
		return a>=left&&a<=right&&b>=top&&b<=bottom;
	}
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	public BufferedImage getImg() {
		return img;
	}


	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	
}
