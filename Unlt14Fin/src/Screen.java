import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel{
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private Target[] bros;
	
	public Screen(String backPath) throws IOException {
		background = ImageIO.read(new File(backPath));
		bros = new Target[5];
		for(int i = 0; i<bros.length; i++) {
			bros[i] = new Target(300*i, 650, 200, "bro.png");
		}
		addMouseListener(new Clicky());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gn = (Graphics2D)g;
		g.drawImage(background, 0, 0, null);
		for(Target bro:bros) {
			bro.draw(gn);
		}
	}
	
	private class Clicky extends MouseAdapter {
		public void mousePressed(MouseEvent me) {
			int x = me.getX();
			int y = me.getY();
			Graphics g = getGraphics();
			for(Target t: bros) {
				if (t.isInside(x, y)) {
					t.setX(2000);
				}
			}
			g.fillOval(x-25, y-25, 50, 50);
			repaint();

		}
	}
}
