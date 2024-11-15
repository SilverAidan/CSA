import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class baseplate {
	public static int level = 0;
	public static int type = 1;
	public static boolean isNorthChecked = true;
	public static boolean isSouthChecked = true;
	public static boolean isEastChecked = true;
	public static boolean isWestChecked = true;
	public static boolean isNortheastChecked = false;
	public static boolean isSoutheastChecked = false;
	public static boolean isNorthwestChecked = false;
	public static boolean isSouthwestChecked = false;
	public static boolean isCenterChecked = true;
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("LEGO Recursion");
		frame.setSize(1600,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
        
		
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 5, 0);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		frame.add(slider, BorderLayout.SOUTH);
		lego p = new lego(400, 50, 800, 800);
		frame.add(p, BorderLayout.CENTER);
		frame.setVisible(true);
		
		JFrame checkboxFrame = new JFrame("Where");
		checkboxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel checkboxPanel = new JPanel(new GridLayout(3, 3));
		JCheckBox[] checkboxes = new JCheckBox[9];
		
		String[] cardinalDirections = {
			    "Northwest", "North", "Northeast",
			    "West", "Center", "East",
			    "Southwest", "South", "Southeast"
			};

		for (int i = 0; i < checkboxes.length; i++) {
		    checkboxes[i] = new JCheckBox(cardinalDirections[i]);
		}
		
		ChangeListener checkboxChangeListener = new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        JCheckBox source = (JCheckBox) e.getSource();
		        boolean isSelected = source.isSelected();
		        String checkboxName = source.getText(); 
		        
		        switch (checkboxName) {
		            case "North":
		                isNorthChecked = isSelected;
		                break;
		            case "South":
		                isSouthChecked = isSelected;
		                break;
		            case "East":
		                isEastChecked = isSelected;
		                break;
		            case "West":
		                isWestChecked = isSelected;
		                break;
		            case "Northeast":
		                isNortheastChecked = isSelected;
		                break;
		            case "Southeast":
		                isSoutheastChecked = isSelected;
		                break;
		            case "Northwest":
		                isNorthwestChecked = isSelected;
		                break;
		            case "Southwest":
		                isSouthwestChecked = isSelected;
		                break;
		            case "Center":
		                isCenterChecked = isSelected;
		                break;
		        }
		    }
		};
		
		for (int i = 0; i < 9; i++) {
		    JCheckBox checkbox = new JCheckBox(cardinalDirections[i]);
		    checkbox.addChangeListener(checkboxChangeListener);
		    checkboxes[i] = checkbox;
		    checkboxPanel.add(checkbox);
		}

		checkboxFrame.add(checkboxPanel);
		checkboxFrame.pack();
		checkboxFrame.setVisible(true);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(slider.getValue() != level) {;
					level = slider.getValue();
					p.setLevel(level);
					frame.repaint();
				}
			}
		});
	}


	public static boolean isNorthChecked() {
		return isNorthChecked;
	}


	public static void setNorthChecked(boolean isNorthChecked) {
		baseplate.isNorthChecked = isNorthChecked;
	}


	public static boolean isSouthChecked() {
		return isSouthChecked;
	}


	public static void setSouthChecked(boolean isSouthChecked) {
		baseplate.isSouthChecked = isSouthChecked;
	}


	public static boolean isEastChecked() {
		return isEastChecked;
	}


	public static void setEastChecked(boolean isEastChecked) {
		baseplate.isEastChecked = isEastChecked;
	}


	public static boolean isWestChecked() {
		return isWestChecked;
	}


	public static void setWestChecked(boolean isWestChecked) {
		baseplate.isWestChecked = isWestChecked;
	}


	public static boolean isNortheastChecked() {
		return isNortheastChecked;
	}


	public static void setNortheastChecked(boolean isNortheastChecked) {
		baseplate.isNortheastChecked = isNortheastChecked;
	}


	public static boolean isSoutheastChecked() {
		return isSoutheastChecked;
	}


	public static void setSoutheastChecked(boolean isSoutheastChecked) {
		baseplate.isSoutheastChecked = isSoutheastChecked;
	}


	public static boolean isNorthwestChecked() {
		return isNorthwestChecked;
	}


	public static void setNorthwestChecked(boolean isNorthwestChecked) {
		baseplate.isNorthwestChecked = isNorthwestChecked;
	}


	public static boolean isSouthwestChecked() {
		return isSouthwestChecked;
	}


	public static void setSouthwestChecked(boolean isSouthwestChecked) {
		baseplate.isSouthwestChecked = isSouthwestChecked;
	}


	public static boolean isCenterChecked() {
		return isCenterChecked;
	}


	public static void setCenterChecked(boolean isCenterChecked) {
		baseplate.isCenterChecked = isCenterChecked;
	}

}