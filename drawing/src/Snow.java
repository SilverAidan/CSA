import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Snow extends JPanel {
    private int x, y;

    // Constructor to initialize the Snow object with coordinates
    public Snow(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    // Method to draw a snowflake
    public void drawSnow(Graphics2D g) {
        // Setting the color to white and filling an oval at specified coordinates
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 5, 5);
    }

    // Getter method for x coordinate
    public int getX() {
        return x;
    }

    // Setter method for x coordinate
    public void setX(int x) {
        this.x = x;
    }

    // Getter method for y coordinate
    public int getY() {
        return y;
    }

    // Setter method for y coordinate
    public void setY(int y) {
        this.y = y;
    }
}