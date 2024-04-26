import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Chairlift extends JPanel {
    // Instance variables for the position of the chairlift
    private int x, y;

    // Constructor to initialize the chairlift's position
    public Chairlift(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    // Method to draw the chairlift using the provided Graphics2D object
    public void drawChairlift(Graphics2D g) {
        // Set the color of the chair
        Color chairColor = new Color(99, 99, 99);
        g.setColor(chairColor);

        // Draw a rectangle representing the chairlift
        g.drawRect(x, y, 30, 7);
    }

    // Getter method for the x-coordinate of the chairlift
    public int getX() {
        return x;
    }

    // Setter method for the x-coordinate of the chairlift
    public void setX(int x) {
        this.x = x;
    }

    // Getter method for the y-coordinate of the chairlift
    public int getY() {
        return y;
    }

    // Setter method for the y-coordinate of the chairlift
    public void setY(int y) {
        this.y = y;
    }
}