import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel implements MouseMotionListener, KeyListener, ActionListener{
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private Target[] bros;
	private Target selectedTarget;
	private Timer t;
	
	public Screen(String backPath) throws IOException {
		background = ImageIO.read(new File(backPath));
		bros = new Target[5];
		for(int i = 0; i<bros.length; i++) {
			bros[i] = new Target(300*i, 650, 200, "bro.png");
		}
		addMouseListener(new Clicky());
		addKeyListener(this);
		addMouseMotionListener(this);
		t = new Timer(17,this);
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gn = (Graphics2D)g;
		g.drawImage(background, 0, 0, null);
		for(Target bro:bros) {
			
		}
	}
	
	private class Clicky extends MouseAdapter {
		public void mousePressed(MouseEvent me) {
			if(me.getButton() == MouseEvent.BUTTON1) {
				int x = me.getX();
				int y = me.getY();
				Graphics g = getGraphics();
				for(Target t: bros) {
					if (t.isInside(x, y)) {
						t.setX(2000);
					}
				}
				repaint();
			}
				
			else if(me.getButton() == MouseEvent.BUTTON3) {
				int x = me.getX();
				int y = me.getY();
				Graphics g = getGraphics();
				for(Target t: bros) {
					if (t.isInside(x, y)) {
						selectedTarget = t;
					}
			}
				repaint();
	
			}
		}
		public void mouseReleased(MouseEvent me) {
			selectedTarget = null;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(selectedTarget != null) {
			selectedTarget.setX(e.getX() - selectedTarget.getRadius());
			selectedTarget.setY(e.getY() - selectedTarget.getRadius());
			repaint();
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("HEHEHHA");
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_R) {
			for(int i = 0; i < bros.length; i++) {
				bros[i].setX(300*i);
				bros[i].setY(650);
				repaint();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			t.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(Target t : bros) {
			t.setY(t.getY()-5);
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
