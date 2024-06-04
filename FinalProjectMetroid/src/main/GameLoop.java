package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import entities.Samus;
import levels.LevelManager;
import utilities.loadnsave;

public class GameLoop implements Runnable {
	private GameScreen screen;
	private Thread gameThread;
	private final int fps = 120;
	private final int ups = 200;
	private Samus aran;
	private LevelManager levelManager;
	
	public final static int tileSize = 32;
	public final static float scale = 2f;
	public final static int tilesWidth = 26;
	public final static int tilesHeight = 14;
	public final static int tilesSize = (int) (tileSize * scale);
	public final static int gameWidth = tilesSize * tilesWidth;
	public final static int gameHeight = tilesSize * tilesHeight;
	
	private int xLevelOffset;
	private int leftBorder = (int)(.2 * gameWidth);
	private int rightBorder = (int)(.8 * gameWidth);
	private int levelTilesWidth = loadnsave.getLevelData()[0].length;
	private int maxTilesOffset = levelTilesWidth - tilesWidth;
	private int maxLevelOffsetX = maxTilesOffset * tilesSize;
	
	private BufferedImage background;
	
	public GameLoop() throws IOException {
		initializeEntities();
		screen = new GameScreen(this);
		new GameWindow(screen);
		screen.requestFocusInWindow();
		startGameLoop();
	}

	private void initializeEntities() throws IOException {
		background = loadnsave.getSpriteAtlas(loadnsave.playingBg);
		levelManager = new LevelManager(this);
		aran = new Samus(200, 200, (int)(28 * scale), (int)(37 * scale));
		aran.loadLevelData(levelManager.getCurrentLevel().getLevelData());;
	}
	
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, GameLoop.gameWidth, GameLoop.gameHeight, null);
		levelManager.draw(g, xLevelOffset);
		aran.render(g, xLevelOffset);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		levelManager.update();
		aran.update();
		checkCloseBorder();;
	}

	private void checkCloseBorder() {
	    int playerX = (int) aran.getHitbox().x;
	    int diff = playerX - xLevelOffset;

	    if (diff > rightBorder) {
	        xLevelOffset += diff - rightBorder;
	    } else if (diff < leftBorder) {
	        xLevelOffset += diff - leftBorder;
	    }

	    if (xLevelOffset > maxLevelOffsetX) { 
	        xLevelOffset = maxLevelOffsetX;
	    } else if (xLevelOffset < 0) {
	        xLevelOffset = 0;
	    }
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / fps;
		double timePerUpdate = 1000000000.0 / ups;
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