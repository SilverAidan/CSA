package utilities;

import java.awt.geom.Rectangle2D;

import main.GameLoop;

public class Helpers {

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        int startX = (int) (x / GameLoop.tilesSize);
        int startY = (int) (y / GameLoop.tilesSize);
        int endX = (int) ((x + width) / GameLoop.tilesSize);
        int endY = (int) ((y + height) / GameLoop.tilesSize);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (IsSolid(i * GameLoop.tilesSize, j * GameLoop.tilesSize, lvlData)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean IsSolid(float x, float y, int[][] levelData) {
    	int maxWidth = levelData[0].length * GameLoop.tilesSize;
        if (x < 0 || x >= maxWidth || y < 0 || y >= GameLoop.gameHeight) {
            return true;
        }

        float xIndex = x / GameLoop.tilesSize;
        float yIndex = y / GameLoop.tilesSize;

        int value = levelData[(int) yIndex][(int) xIndex];

        // Adjust the condition to consider all solid tiles
        if (value >= 48 || value < 0 || value != 11) {
            return true;
        }
        return false;
    }

	public static float GetEntityXWall(Rectangle2D.Float hitbox, float xSpeed) {
		int currentTile = (int) (hitbox.x / GameLoop.tilesSize);
		if (xSpeed > 0) {
			int tileXPos = currentTile * GameLoop.tilesSize;
			int xOffset = (int) (GameLoop.tilesSize - hitbox.width);
			return tileXPos + xOffset - 1;
		} else
			return currentTile * GameLoop.tilesSize;
	}

	public static float GetEntityYRoof(Rectangle2D.Float hitbox, float airSpeed) {
	    int currentTile = (int) (hitbox.y / GameLoop.tilesSize);
	    if (airSpeed > 0) {
	        int tileYPos = currentTile * GameLoop.tilesSize;
	        int yOffset = (int) (GameLoop.tilesSize - hitbox.height);
	        return tileYPos + yOffset - 1;
	    } else {
	        return (currentTile + 1) * GameLoop.tilesSize;
	    }
	}

	public static boolean Floored(Rectangle2D.Float hitbox, int[][] lvlData) {
		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
			if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
				return false;

		return true;

	}
}