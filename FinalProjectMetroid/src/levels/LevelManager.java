package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.GameLoop;
import utilities.loadnsave;

public class LevelManager {
	
	
	private GameLoop loop;
	private BufferedImage[] levelSprite;
	private Level levelOne;

	public LevelManager(GameLoop loop) throws IOException {
		this.loop = loop;
		importOutsideSprites();
		levelOne = new Level(loadnsave.getLevelData());
	}
	
	private void importOutsideSprites() throws IOException {
		BufferedImage img = loadnsave.getSpriteAtlas(loadnsave.levelAtlas);
		levelSprite = new BufferedImage[48];
		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 12; i++) {
				int index = j * 12 + i;
				levelSprite[index] = img.getSubimage(i * 32, j * 32, 32, 32);
			}
	}
	
	public void draw(Graphics g, int xLevelOffset) {
		for(int j = 0; j < GameLoop.tilesHeight; j++) {
			for(int i = 0; i < levelOne.getLevelData()[0].length; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], GameLoop.tilesSize*i - xLevelOffset, GameLoop.tilesSize*j, GameLoop.tilesSize, GameLoop.tilesSize, null);
			}
		}
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}
	
	public void update() {
		
	}

}
