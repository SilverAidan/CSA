package main;

import java.io.IOException;

public class GameLoop implements Runnable {

	private GameWindow window;
	private GameScreen screen;
	private Thread gameThread;
	private final int fps = 120;
	private final int ups = 200;

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
	
	public void update() {
		screen.updateGame();
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / fps;
		double timePerUpdate = 1000000000.0 / ups;
		long now = System.nanoTime();
		
		long previousTime = System.nanoTime();

		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaUpdate = 0;
		double deltaFrames = 0;
		
		while (true) {
			long currentTime = System.nanoTime();
			
			
			deltaUpdate += (currentTime - previousTime) / timePerUpdate;
			deltaFrames += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			if(deltaUpdate >= 1) {
				update();
				updates++;
				deltaUpdate--;
			}
			
			if(deltaFrames >= 1) {
				screen.repaint();
				deltaFrames--;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("frames: " + frames + " | ups: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}


}