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
	public int level;
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
		drawFractal(g,l,0);
	}

	private void drawFractal(Graphics2D g, legoPiece piece, int currentLevel) {
		
	    if (currentLevel >= level) {
	    	piece.drawLego(g);
	        return;
	    }

	    // Calculate the size of the new cubes
	    int newWidth = piece.getWidth() / 3;
	    int newHeight = piece.getHeight() / 3;

	    // Calculate the positions for the new cubes
	    int x1 = piece.getX();
	    int y1 = piece.getY();

	    // Create new legoPiece objects for each new cube
	    legoPiece center = new legoPiece(x1 + newWidth, y1 + newHeight, newWidth, newHeight);
	    legoPiece topLeft = new legoPiece(x1, y1, newWidth, newHeight);
	    legoPiece topRight = new legoPiece(x1 + 2*newWidth, y1, newWidth, newHeight);
	    legoPiece bottomLeft = new legoPiece(x1, y1 + 2*newHeight, newWidth, newHeight);
	    legoPiece bottomRight = new legoPiece(x1 + 2*newWidth, y1 + newHeight * 2, newWidth, newHeight);

	    // Recursively draw each new cube
	    drawFractal(g, center, currentLevel + 1);
	    drawFractal(g, topLeft, currentLevel + 1);
	    drawFractal(g, topRight, currentLevel + 1);
	    drawFractal(g, bottomLeft, currentLevel + 1);
	    drawFractal(g, bottomRight, currentLevel + 1);
	}

}