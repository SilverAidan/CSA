import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Samus {
	private int x,y;
	private int radius;
	private BufferedImage currentSprite;
	private int spriteNum = 6;
	private BufferedImage[] runSprites = new BufferedImage[10];


	public Samus(int x, int y, int radius, String imgPath) throws IOException {
		super();
		for(int i = 1; i <= runSprites.length; i++) {
			runSprites[i-1] = ImageIO.read(new File("sprites\\samus\\run\\" + i + ".png"));
		}
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.currentSprite = runSprites[spriteNum];
	}
	
	public void draw(Graphics g) {
		g.drawImage(currentSprite, x, y, null);
	}
	public boolean isInside(int a, int b) {
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


	public BufferedImage getCurrentSprite() {
		return currentSprite;
	}

	public void setCurrentSprite(BufferedImage currentSprite) {
		this.currentSprite = currentSprite;
	}

	public int getSpriteNum() {
		return spriteNum;
	}

	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
		currentSprite = runSprites[spriteNum];
	}
	
}
