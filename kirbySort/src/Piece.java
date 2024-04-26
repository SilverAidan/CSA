import java.awt.Color;
import java.awt.Graphics2D;

public class Piece {
	Color c;
	int kirbyX, kirbyY;
	public static int kirbyCount;
	public Piece(int number) {
		float r = (float)(Math.random()*.4 + 1);
		this.c = new Color((int)(250/r)-1,(int)(185/r),(int)(220/r));
		kirbyX = (1500 - 80 * kirbyCount) / (kirbyCount + 1) * (number + 1) + 80 * number;
	}
	
	public void drawKirby(Graphics2D newG, boolean isSelected) {
		
		//shoes
		newG.setColor(new Color(255,0,80));
		newG.fillOval(kirbyX, 660, 40, 20);
		newG.fillOval(kirbyX+40, 660, 40, 20);
		
		//arms
		newG.setColor(c);
		if(isSelected)
			newG.fillOval(kirbyX, 600, 20, 40);
		else
			newG.fillOval(kirbyX-5, 620, 20, 40);
		newG.fillOval(kirbyX+65, 620, 20, 40);
		newG.setColor(c.darker());
		newG.fillOval(kirbyX-1, 622, 20, 40);
		newG.fillOval(kirbyX+61, 622, 20, 40);
		
		//body
		newG.setColor(c);
		newG.fillOval(kirbyX, 600, 80, 80);
		
		//eye shapes
		newG.setColor(Color.black);
		newG.fillOval(kirbyX+22, 620, 10, 20);
		newG.fillOval(kirbyX+50, 620, 10, 20);
		
		//blue spots in eyes
		newG.setColor(new Color(3,38,168));
		newG.fillOval(kirbyX+22, 626, 10, 13);
		newG.fillOval(kirbyX+50, 626, 10, 13);
		
		//white spots in eyes
		newG.setColor(new Color(255,255,255));
		newG.fillOval(kirbyX+25, 622, 5, 10);
		newG.fillOval(kirbyX+52, 622, 5, 10);
		
		//mouth
		newG.setColor(new Color(255,0,0));
		newG.fillOval(kirbyX+34, 650, 15, 10);
		newG.setColor(c);
		newG.fillOval(kirbyX+34, 643, 15, 10);
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}

	public int compareTo(Piece piece) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
