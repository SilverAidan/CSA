import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private Timer t = new Timer(17, null);;
	
	public GameScreen(String backPath) throws IOException {
		background = ImageIO.read(new File(backPath));
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gn = (Graphics2D)g;
		gn.drawImage(background, 0, 0, null);
	}

}
