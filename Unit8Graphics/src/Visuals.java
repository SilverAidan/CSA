import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class Visuals {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame foundation = new JFrame();
		foundation.setSize(1000, 800);
		foundation.setVisible(true);
		foundation.setResizable(false);
		foundation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vehicle v = new Vehicle();
		foundation.add(v);
		Thread.sleep(1000);
		foundation.setVisible(true);
		int i = 0; int deltaI = 1;
		
		
//		int input = Integer.parseInt(JOptionPane.showInputDialog("gimme number"));
//		v.setCloudSpeed(input);
		Integer[] choices = {0,1,2,3,4,5,6};
		Integer Choice = (Integer)JOptionPane.showInputDialog(foundation, "Cloud Speed", "What cloud speed?", JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);
		v.setCloudSpeed(Choice);
		Color otherColor = JColorChooser.showDialog(foundation, "Give color", Color.red);
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 2);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		foundation.add(slider,BorderLayout.SOUTH);
		foundation.setVisible(true);
		
		
		while(true) {	
			i+=deltaI;
			if (i==255||i==0) {
				deltaI*=-1;
			}
			Color c = new Color(i,i,0);
			v.setBackground(c);
			Thread.sleep(10);
			v.setCloudSpeed(slider.getValue());
		}
		
		
	}

}
