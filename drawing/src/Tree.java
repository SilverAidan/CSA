import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tree extends JPanel {
    private int x, y;

    // Constructor to initialize the Tree object with coordinates
    public Tree(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    // Method to draw a tree with specified treeColor
    public void drawTree(Graphics2D g, Color treeColor) {
        // Drawing the tree trunk in a dark brown color
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x + 10, y, 15, 45);

        // Drawing three circles as the tree leaves, using the specified treeColor
        g.setColor(treeColor);
        g.fillOval(x, y - 30, 35, 35);
        g.fillOval(x + 10, y - 15, 35, 35);
        g.fillOval(x - 10, y - 15, 35, 35);
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