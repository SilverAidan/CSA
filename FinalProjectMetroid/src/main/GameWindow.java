package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame frame;

	public GameWindow(GameScreen screen) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(screen);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}