import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lego extends JPanel{
	private static final long serialVersionUID = 1L;
	public int level, type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	int x, y, width, height;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public lego(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setBackground(Color.white);
		this.setSize(getWidth(), getHeight());
		level = 0;
		
	}
	public void paintComponent(Graphics gold) {
		super.paintComponent(gold);
		Graphics2D g = (Graphics2D)gold;
		legoPiece l = new legoPiece(x,y,width,height);
		try {
			g.drawImage(ImageIO.read(new File("baseplate.jpg")), 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		drawFractal(g,l,0,type);
	}

	private void drawFractal(Graphics2D g, legoPiece piece, int currentLevel, int type) {
		Color c = Color.red;
		int newWidth = piece.getWidth() / 3;
		int newHeight = piece.getHeight() / 3;
		int x1 = piece.getX();
		int y1 = piece.getY();
	    legoPiece center = new legoPiece(x1 + newWidth, y1 + newHeight, newWidth, newHeight);
	    legoPiece topLeft = new legoPiece(x1, y1, newWidth, newHeight);
	    legoPiece topRight = new legoPiece(x1 + 2 * newWidth, y1, newWidth, newHeight);
		legoPiece bottomLeft = new legoPiece(x1, y1 + 2 * newHeight, newWidth, newHeight);
		legoPiece bottomRight = new legoPiece(x1 + 2 * newWidth, y1 + newHeight * 2, newWidth, newHeight);
		legoPiece left = new legoPiece(x1, y1 + newHeight, newWidth, newHeight);
		legoPiece right = new legoPiece(x1 + newHeight*2, y1+ newHeight, newWidth, newHeight);
		legoPiece top = new legoPiece(x1 + newWidth, y1, newWidth, newHeight);
		legoPiece bottom = new legoPiece(x1 + newWidth, y1 + newHeight*2, newWidth, newHeight);
	    if (currentLevel >= level) {
	    	piece.drawLego(g, c);
	        return;
	    }
		if (baseplate.isCenterChecked()) {
			drawFractal(g, center, currentLevel + 1, type);
		}
		if (baseplate.isWestChecked()) {
			drawFractal(g, left, currentLevel + 1, type);
		}
		if (baseplate.isEastChecked()) {
			drawFractal(g, right, currentLevel + 1, type);
		}
		if (baseplate.isSouthChecked()) {
			drawFractal(g, bottom, currentLevel + 1, type);
		}
		if (baseplate.isNorthChecked()) {
			drawFractal(g, top, currentLevel + 1, type);
		}
		if (baseplate.isNorthwestChecked()) {
			drawFractal(g, topLeft, currentLevel + 1, type);
		}
		if (baseplate.isNortheastChecked()) {
			drawFractal(g, topRight, currentLevel + 1, type);
		}
		if (baseplate.isSouthwestChecked()) {
			drawFractal(g, bottomLeft, currentLevel + 1, type);
		}
		if (baseplate.isSoutheastChecked()) {
			drawFractal(g, bottomRight, currentLevel + 1, type);
		}
		
	}

}