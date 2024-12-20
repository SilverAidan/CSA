import java.awt.Color;
import java.awt.Graphics;

public class Cloud {
	private int x,y;
	private Color cColor;
	
	public Cloud(int x, int y, Color cColor) {
		super();
		this.x = x;
		this.y = y;
		this.cColor = cColor;
	}
	
	public void drawCloud(Graphics g) {
		g.setColor(cColor);
		g.fillOval(x+20, y, 30, 30);
		g.fillOval(x+20, y+20, 30, 30);
		g.fillOval(x+30, y+20, 30, 30);
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
	public Color getcColor() {
		return cColor;
	}
	public void setcColor(Color cColor) {
		this.cColor = cColor;
	}
	
}
