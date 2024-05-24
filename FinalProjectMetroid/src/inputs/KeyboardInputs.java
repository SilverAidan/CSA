package inputs;

import java.awt.event.KeyEvent;
import static utilities.Constants.Directions.*;
import java.awt.event.KeyListener;

import main.GameScreen;

public class KeyboardInputs implements KeyListener {

	private GameScreen screen; 
	
	public KeyboardInputs(GameScreen screen) {
		this.screen = screen;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			screen.getLoop().getSamus().setUp(true);
			break;
		case KeyEvent.VK_A:
			screen.getLoop().getSamus().setLeft(true);
			break;
		case KeyEvent.VK_S:
			screen.getLoop().getSamus().setDown(true);
			break;
		case KeyEvent.VK_D:
			screen.getLoop().getSamus().setRight(true);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			screen.getLoop().getSamus().setUp(false);
			break;
		case KeyEvent.VK_A:
			screen.getLoop().getSamus().setLeft(false);
			break;
		case KeyEvent.VK_S:
			screen.getLoop().getSamus().setDown(false);
			break;
		case KeyEvent.VK_D:
			screen.getLoop().getSamus().setRight(false);
			break;
		}
	}

}
