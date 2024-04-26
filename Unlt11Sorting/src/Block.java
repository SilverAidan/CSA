import java.awt.Color;

public class Block {
	private Color c;
	private int y;
	
	public Block(Color c, int y) {
		super();
		this.c = c;
		this.y = y;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int compareTo(Object other) {
		return this.c.getBlue()-((Block)other).getC().getBlue();
	}
	
}
