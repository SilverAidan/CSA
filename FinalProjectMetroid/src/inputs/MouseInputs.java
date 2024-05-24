package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static utilities.Constants.PlayerConstants.*;

import main.GameScreen;

public class MouseInputs implements MouseListener, MouseMotionListener{

	private GameScreen screen;
	public MouseInputs(GameScreen screen) {
		this.screen = screen;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		if(e.getY() < 266) {
//			if(!screen.getLoop().getSamus().isMoving())
//				screen.getLoop().getSamus().setPlayerAction(aimingUp);
//		}
//		if(e.getY() < 532 && e.getY() > 266) {
//			if(!screen.getLoop().getSamus().isMoving())
//				screen.getLoop().getSamus().setPlayerAction(aimingStraight);
//		}
//		if(e.getY() > 532) {
//			if(!screen.getLoop().getSamus().isMoving())
//				screen.getLoop().getSamus().setPlayerAction(aimingDown);
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked!");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
