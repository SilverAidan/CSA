import java.io.IOException;

import javax.swing.JFrame;

public class FinalDriver {

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setTitle("Shootem!");
		frame.setSize(1600,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		
		Screen s = new Screen("C:\\Users\\kametza\\Desktop\\APCS\\Unlt14Fin\\background.png");
		
		frame.add(s);
		frame.setVisible(true);
	}

}
