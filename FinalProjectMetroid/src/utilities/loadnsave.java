package utilities;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GameLoop;

public class loadnsave {
	
	public static final String playerAtlas = "sprites\\samus\\sprite Atlas.png";
	public static final String levelAtlas = "sprites\\level.png";
	public static final String levelOne = "sprites\\level1.png";
	
	public static BufferedImage getSpriteAtlas(String fileName) throws IOException {
		BufferedImage sprite;
		sprite = ImageIO.read(new File(fileName));
		return sprite;
	}
	
	public static int[][] getLevelData() throws IOException{
		int[][] levelData = new int[GameLoop.tilesHeight][GameLoop.tilesWidth];
		BufferedImage img = getSpriteAtlas(levelOne);
		
		for(int j = 0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				levelData[j][i] = color.getRed();
			}
		}
		
		return levelData;
	}
}
