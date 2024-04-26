import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Table extends JPanel{
	private Block[] bloks;
	private int width, height;
	public Table(Block[] bloks, int width, int height) {
		super();
		this.bloks = bloks;
		this.width = width;
		this.height = height;
	}
	public void paintComponent(Graphics g) {
		Graphics2D newG = (Graphics2D)g;
		for(Block b:bloks) {
			newG.setColor(b.getC());
			newG.fillRect(0, b.getY(), width, height/bloks.length);
		}
	}
	public Block[] getBloks() {
		return bloks;
	}
	public void setBloks(Block[] bloks) {
		this.bloks = bloks;
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
