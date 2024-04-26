import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class EnglandDriver {
	
    public static void main(String[] args) throws InterruptedException {
    	int restart = JOptionPane.YES_OPTION;
    	while(restart == JOptionPane.YES_OPTION) { 
	    	// Create the main JFrame
	        JFrame foundation = new JFrame();
	        foundation.setSize(1935, 1035);
	        foundation.setResizable(false);		
	        foundation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	        // Allow the user to choose a color for the tree leaves using JColorChooser
	        Color treeColor = JColorChooser.showDialog(null, "Choose a Color for the Tree Leaves", Color.WHITE);
	
	        // Create a JSlider for controlling chair speed
	        JSlider slider = new JSlider(1, 5, 3);
	        slider.setMajorTickSpacing(1);
	        slider.setMinorTickSpacing(1);;
	        foundation.add(slider, BorderLayout.SOUTH);
	
	        // Initialize chair speed and NewEngland object
	        int skiierX = slider.getValue();
	        NewEngland NE = new NewEngland(skiierX, treeColor);
	        foundation.add(NE);
	
	        // Set the JFrame to be visible
	        foundation.setVisible(true);
	
	        // Main loop for updating chair speed and repainting the JFrame
	        for(int i = 0; i < 750; i++) {
	            skiierX = slider.getValue();
	            NE.setSkiierX(skiierX);
	            foundation.repaint();
	            Thread.sleep(15);
	        }
	    
	        restart = JOptionPane.showConfirmDialog(null, "Do you want to restart?", "Restart?" , JOptionPane.YES_NO_OPTION);
	        if(restart == JOptionPane.NO_OPTION) {
	        	System.exit(0);
	        }
    	}
    }
}
