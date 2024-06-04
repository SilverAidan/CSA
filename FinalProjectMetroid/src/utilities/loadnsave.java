package utilities;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GameLoop;

public class loadnsave {
	
	public static final String playerAtlas = "sprites\\samus\\sprite Atlas.png";
	public static final String levelAtlas = "sprites\\outside_sprites.png";
	public static final String levelOne = "sprites\\level_one_data_long.png";
	public static final String playingBg = "sprites\\bg.png";
	
	public static BufferedImage getSpriteAtlas(String fileName) throws IOException {
		BufferedImage sprite;
		sprite = ImageIO.read(new File(fileName));
		return sprite;
	}
	
	public static int[][] getLevelData() throws IOException{
		BufferedImage img = getSpriteAtlas(levelOne);
		int[][] levelData = new int[img.getHeight()][img.getWidth()];
		for(int j = 0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if(value >= 48) 
					value = 0;
				levelData[j][i] = value;
			}
		}
		
		return levelData;
	}
}
