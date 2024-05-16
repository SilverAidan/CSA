import java.io.IOException;
import javax.swing.JFrame;

public class GameDriver {

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("Metroid: Nexus");
		frame.setSize(1600,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		GameScreen s = new GameScreen("C:\\Users\\kametza\\Desktop\\APCS\\FinalProjectMetroid\\sprites\\Stage.png");
		frame.add(s);
		frame.setVisible(true);
	}
}
