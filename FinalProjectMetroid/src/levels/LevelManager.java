package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.GameLoop;
import utilities.loadnsave;

public class LevelManager {
	
	
	private GameLoop loop;
	private BufferedImage[] levelSprite;

	public LevelManager(GameLoop loop) throws IOException {
		this.loop = loop;
		importOutsideSprites();
	}
	
	private void importOutsideSprites() throws IOException {
	    BufferedImage img = loadnsave.getSpriteAtlas(loadnsave.levelAtlas);
	    levelSprite = new BufferedImage[1664];
	    for (int i = 0; i < 64; i++) { 
	        for (int j = 0; j < 26; j++) { 
	            int index = i * 26 + j;
	            levelSprite[index] = img.getSubimage(i * 16, j * 16, 16, 16);
	        }
	    }
	}
	
	public void draw(Graphics g) {
		g.drawImage(levelSprite[9], 0, 0, null);
	}
	
	public void update() {
		
	}
}
