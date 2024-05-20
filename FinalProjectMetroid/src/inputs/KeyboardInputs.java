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
			screen.setDirection(up);
			break;
		case KeyEvent.VK_A:
			screen.setDirection(left);
			break;
		case KeyEvent.VK_S:
			screen.setDirection(down);
			break;
		case KeyEvent.VK_D:
			screen.setDirection(right);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			screen.setMoving(false);
			break;
		case KeyEvent.VK_A:
			screen.setMoving(false);
			break;
		case KeyEvent.VK_S:
			screen.setMoving(false);
			break;
		case KeyEvent.VK_D:
			screen.setMoving(false);
			break;
		}
	}

}
