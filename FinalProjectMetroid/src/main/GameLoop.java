package main;

import java.io.IOException;

public class GameLoop implements Runnable {

	private GameWindow window;
	private GameScreen screen;
	private Thread gameThread;
	private final int FPS_SET = 120;

	public GameLoop() throws IOException {

		screen = new GameScreen();
		window = new GameWindow(screen);
		screen.requestFocusInWindow();
		startGameLoop();

	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();

		int frames = 0;
		long lastCheck = System.currentTimeMillis();

		while (true) {

			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				screen.repaint();
				lastFrame = now;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}

	}

}