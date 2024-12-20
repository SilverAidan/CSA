import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class legoPiece{
	private int x, y, width, height;
	
	public legoPiece(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	public void drawLego(Graphics2D g, Color c) {
		g.setColor(c);
		Rectangle r = new Rectangle(x, y, width, height);
		g.fill(r);
		g.setColor(c.darker());
		g.fillOval(r.x + r.width / 10, r.y + r.height / 10, r.width / 4, r.width / 4);
		g.fillOval(r.x + r.width - r.width / 4 - r.width / 10, r.y + r.height / 10, r.width / 4, r.width / 4);
		g.fillOval(r.x + r.width / 10, r.y + r.height - r.width / 4 - r.height / 10, r.width / 4, r.width / 4);
		g.fillOval(r.x + r.width - r.width / 4 - r.width / 10, r.y + r.height - r.width / 4 - r.height / 10, r.width / 4, r.width / 4);
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


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	
}