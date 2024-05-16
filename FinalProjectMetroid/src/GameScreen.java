import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements MouseListener, ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private Timer t;
	private Samus aran = new Samus(100,100,400,"sprites\\samus\\run\\6.png");
	
	public GameScreen(String backPath) throws IOException {
		addMouseListener(new Clicky());
		addKeyListener(this);
		t = new Timer(17,this);
		setFocusable(true);
		t.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gn = (Graphics2D)g;
		aran.draw(gn);
	}
	
	private class Clicky extends MouseAdapter {
		public void mousePressed(MouseEvent me) {
			if(me.getButton() == MouseEvent.BUTTON1) {
				repaint();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println(aran.getSpriteNum());
		if(e.getKeyCode() == KeyEvent.VK_W) {
			aran.setY(aran.getY()-10);
			aran.setSpriteNum((aran.getSpriteNum() + 1)%10);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			aran.setX(aran.getX()-10);
			aran.setSpriteNum((aran.getSpriteNum() + 1)%10);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			aran.setY(aran.getY()+10);
			aran.setSpriteNum((aran.getSpriteNum() + 1)%10);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			aran.setX(aran.getX()+10);
			aran.setSpriteNum((aran.getSpriteNum() + 1)%10);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}