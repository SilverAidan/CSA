import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class trashArt {
	public static int level = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Feet Mondrian 2.0");
		frame.setSize(1600,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 15, 0);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		frame.add(slider, BorderLayout.SOUTH);
		painting p = new painting();
		frame.add(p, BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(slider.getValue() != level) {
					level = slider.getValue();
					p.setLevel(level);
					frame.repaint();
				}
			}
		});
	}

}
