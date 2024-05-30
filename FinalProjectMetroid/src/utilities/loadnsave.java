package utilities;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class loadnsave {
	
	public static final String playerAtlas = "sprites\\samus\\sprite Atlas.png";
	
	public static BufferedImage getSpriteAtlas(String fileName) throws IOException {
		BufferedImage sprite;
		sprite = ImageIO.read(new File(fileName));
		return sprite;
	}
}
