import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class painting extends JPanel{
	private static final long serialVersionUID = 1L;
	public int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public painting() {
		setBackground(Color.white);
		this.setSize(getWidth(), getHeight());
		level = 0;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Rectangle r = new Rectangle(0,0,getWidth(),getHeight());
		mondy(g,r,0);
	}

	private void mondy(Graphics g, Rectangle r, int lev) {
		if(lev >= level) {
			return;
		}
		int red = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		Color c = new Color(red, green, blue);
		g.setColor(c);
		Graphics2D g2 = (Graphics2D)g;
		g2.fill(r);
		if(Math.random()>.5) {
			Rectangle top = new Rectangle(r.x,r.y,r.width,r.height/2);
			Rectangle bot = new Rectangle(r.x,r.y+r.height/2,r.width,r.height/2);
			mondy(g,top,lev+1);
			mondy(g,bot,lev+1);
		}else {
			Rectangle left = new Rectangle(r.x,r.y,r.width/2,r.height);
			Rectangle right = new Rectangle(r.x+r.width/2,r.y,r.width/2,r.height);
			mondy(g,left,lev+1);
			mondy(g,right,lev+1);
		}
		
	}
}
