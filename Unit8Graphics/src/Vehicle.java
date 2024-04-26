import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Vehicle extends JPanel {
	private Color cabinColor;
	private Color rimColor;
	private int numWindows;
	private Cloud[] clouds;
	private int cloudSpeed = 2;
	
	public int getCloudSpeed() {
		return cloudSpeed;
	}
	public void setCloudSpeed(int cloudSpeed) {
		this.cloudSpeed = cloudSpeed;
	}
	public Vehicle() {
		cabinColor = Color.cyan;
		rimColor = Color.gray;
		numWindows = 2;
		setBackground(Color.cyan);
		clouds = new Cloud[5];
		for(int i = 0; i < clouds.length; i++) {
			int x = (int)(Math.random()*1000);
			int y = (int)(Math.random()*100);
			int gre = (int)(Math.random()*255);
			Color c = new Color(gre, gre, gre);
			clouds[i] = new Cloud (x, y, c);
					
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(cabinColor);
		g.fillRect(50, 600, 200, 70);
		g.fillRect(85, 550, 130, 50);
		g.setColor(rimColor);
		g.fillOval(60, 660, 30, 30);
		g.fillOval(200, 660, 30, 30);
		
		for(Cloud cloud:clouds) {
			cloud.drawCloud(g);
		}
		moveClouds();
		g.setColor(Color.red);
		Font f = new Font("Pristina", Font.BOLD, 40);
		g.setFont(f);
		g.drawString("Ho Ho Ho", 300, 300);
	}
	public void moveClouds() {
		for(Cloud cloud:clouds) {
			cloud.setX(cloud.getX()+cloudSpeed);
			if(cloud.getX() > this.getWidth()) {
				cloud.setX(-60);
			}
		}
	}
	
}
