package main;

import java.awt.Graphics;
import java.io.IOException;

import entities.Samus;

public class GameLoop implements Runnable {

	private GameWindow window;
	private GameScreen screen;
	private Thread gameThread;
	private final int fps = 120;
	private final int ups = 200;

	private Samus aran;
	
	public GameLoop() throws IOException {
		initializeEntities();
		screen = new GameScreen(this);
		window = new GameWindow(screen);
		screen.requestFocusInWindow();
		startGameLoop();
	}

	private void initializeEntities() throws IOException {
		aran = new Samus(200,200);
		
	}
	
	public void render(Graphics g) {
		aran.render(g);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		aran.update();
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
	
	public void WindowFocusLost() {
		aran.resetDirBooleans();
	}
	
	public Samus getSamus() {
		return aran;
	}


}