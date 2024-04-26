import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NewEngland extends JPanel {
    private Snow[] snowfall;
    private Chairlift chair;
    private int chairliftDirection = 1;
    private Tree[] forest;
    private int skiierX = 3;
    private Color treeColor = Color.white;
    private Skiier aidan;
    private boolean aidanVisible = false;

    // Constructor for the NewEngland class
    public NewEngland(int skiierX, Color treeColor) {
        // Initializing arrays for snowfall and trees
        snowfall = new Snow[500];
        forest = new Tree[30];

        // Populating the arrays with Snow and Tree objects
        for (int i = 0; i < snowfall.length; i++) {
            int x = (int) (Math.random() * 1935);
            int y = (int) (Math.random() * 1035);
            snowfall[i] = new Snow(x, y);
        }
        for (int i = 0; i < forest.length; i++) {
            int x = ((int) (Math.random() * 1100) + 700);
            int y = ((int) (Math.random() * 600) + 350);
            forest[i] = new Tree(x, y);
        }

        // Initializing the chairlift and setting background color
        chair = new Chairlift(587, 895);
        Color c = new Color(19, 24, 98);
        aidan = new Skiier(287, 310);
        this.setBackground(c);
        this.skiierX = skiierX;
        this.treeColor = treeColor;
    }

    public int getSkiierX() {
		return skiierX;
	}

	public void setSkiierX(int skiierX) {
		System.out.println(skiierX);
		switch(skiierX) {
			case 1:
				aidan.setX(267);
				break;
			case 2:
				aidan.setX(277);
				break;
			case 3:
				aidan.setX(287);
				break;
			case 4:
				aidan.setX(307);
				break;
			case 5:
				aidan.setX(317);
		}
	}

	// Override of the paintComponent method to paint the graphics
    public void paintComponent(Graphics old) {
        super.paintComponent(old);
        Graphics2D g = (Graphics2D) old;
        Color mount = new Color(0, 48, 7);
        g.setColor(mount);
        g.fillRect(0, 300, 2000, 1000);
        AffineTransform og = g.getTransform();

        g.setColor(Color.white);
        g.fillRect(200, 300, 200, 300);

        g.rotate(Math.toRadians(30), 300, 600);
        g.fillRect(215, 550, 175, 300);
        g.setTransform(og);

        g.rotate(-Math.toRadians(30), 530, 950);
        g.fillRect(250, 575, 200, 500);
        g.setTransform(og);

        g.setStroke(new BasicStroke(4));
        chair.drawChairlift(g);
        moveChair();

        Color base = new Color(55, 55, 55);
        g.setColor(base);
        g.fillRect(557, 305, 10, 50);
        g.fillRect(557, 920, 10, 50);

        Color cable = new Color(77, 77, 77);
        g.setColor(cable);
        g.fillRect(600, 300, 5, 625);
        g.fillRect(520, 300, 5, 625);
        g.drawOval(522, 280, 80, 40);
        g.drawOval(522, 900, 80, 40);

        for (Tree tree : forest) {
            tree.drawTree(g, treeColor);
        }

        g.setColor(Color.white);
        g.fillOval(1750, 50, 100, 100);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(1750 + 20, 50 + 70, 20, 20);
        g.fillOval(1750 + 40, 50 + 40, 15, 15);
        g.fillOval(1750 + 55, 50 + 10, 25, 25);
        g.fillOval(1750 + 80, 50 + 50, 18, 18);
       
        g.setColor(Color.GRAY);
        g.fillRect(getWidth() - 120, getHeight() - 150, 100, 100);
        int[] xPoints = {getWidth() - 120, getWidth() - 20, getWidth() - 70};
        int[] yPoints = {getHeight() - 150, getHeight() - 150, getHeight() - 220}; 
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(getWidth() - 90, getHeight() - 120, 30, 60); 
        g.setColor(Color.CYAN);
        g.fillRect(getWidth() - 110, getHeight() - 140, 20, 20); // Window 1
        g.fillRect(getWidth() - 70, getHeight() - 140, 20, 20);  // Window 2
        
        if(chair.getY() == 895) {
        	aidanVisible = true;
        }
        
        if(aidanVisible) {
        	aidan.drawSkiier(g);
        	moveSkiier();
        }
        aidan.drawSkiier(g);
        moveSkiier();
        for (Snow flake : snowfall) {
            flake.drawSnow(g);
        }
        moveSnow();
    }

    // Method to move the snowfall
    public void moveSnow() {
        for (Snow flake : snowfall) {
            flake.setY(flake.getY() + 3);
            if (flake.getY() > this.getHeight()) {
                flake.setY(0);
            }
        }
    }
    
    public void moveSkiier() {
            aidan.setY(aidan.getY() + 1);
            if (aidan.getY() > this.getHeight()) {
                aidan.setY(0);
            }
    }

    // Method to move the chairlift
    public void moveChair() {
        chair.setY(chair.getY() - (chairliftDirection));
        if (chair.getY() < 295) {
            chairliftDirection = -1;
            chair.setX(507);
        } else if (chair.getY() > 895) {
            chairliftDirection = 1;
            chair.setX(587);
        }
    }

    

}

