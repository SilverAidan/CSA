package main;
import java.awt.Dimension;
import java.awt.Graphics;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.io.IOException;
import javax.swing.JPanel;
public class GameScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	private MouseInputs m;
	private GameLoop loop;
	
	public GameScreen(GameLoop loop) throws IOException {
		m = new MouseInputs(this);
		this.loop = loop;
		setPanelSize();
		setFocusable(true);
        requestFocusInWindow();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(m);
		addMouseMotionListener(m);
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1600, 800);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
	}
	public GameLoop getLoop() {
		return loop;
	}
	
	public void updateGame() {
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		loop.render(g);
	}
	
}