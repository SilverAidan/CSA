package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static utilities.Constants.PlayerConstants.*;
import static utilities.Constants.Directions.*;

public class GameScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	private MouseInputs m;
	private int xDelta = 100, yDelta = 500; 
	private BufferedImage aim, run;
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 15;
	private int playerAction = idle;
	private int playerDirection = -1;
	private boolean aiming = false, moving = false;
	
	
	public GameScreen() throws IOException {
		importImage();
		loadAnimations();
		m = new MouseInputs(this);
		setPanelSize();
		setFocusable(true);
        requestFocusInWindow();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(m);
		addMouseMotionListener(m);
	}
	
	private void loadAnimations() {
		animations = new BufferedImage[5][10];
		for(int i = 0; i < 1; i++) {
			animations[aimingUp][i] = aim.getSubimage(56, 0, 28, 37);
		}
		for(int i = 0; i < 10; i++) {
			animations[running][i] = run.getSubimage(30*i, 0, 30, 37);
		}
		for(int i = 0; i < 1; i++) {
			animations[idle][i] = aim.getSubimage(28, 0, 28, 37);
		}
		for(int i = 0; i < 1; i++) {
			animations[aimingStraight][i] = aim.getSubimage(28, 0, 28, 37);
		}
		for(int i = 0; i < 1; i++) {
			animations[aimingDown][i] = aim.getSubimage(0, 0, 28, 37);
		}
		
	}

	private void importImage() throws IOException {
		File is = new File("sprites\\samus\\Aim.png");
		aim = ImageIO.read(is);
		is = new File("sprites\\samus\\run.png");
		run = ImageIO.read(is);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1600, 800);
		setMaximumSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateAnimationTick();
		setAnimation();
		updatePosition();
		g.drawImage(animations[playerAction][animationIndex], xDelta, yDelta, 81, 108, null);
	}

	private void updatePosition() {
		if(moving) {
			switch(playerDirection) {
			case(left):
				xDelta -= 5;
				break;
			case(up):
				yDelta -= 5;
				break;
			case(right):
				xDelta += 5;
				break;
			case(down):
				yDelta += 5;
				break;
			}
		}
		
	}

	private void setAnimation() {
	    if (moving) {
	        playerAction = running;
	    } else {
	        if (playerAction != idle && !isPerformingOtherAction()) {
	            playerAction = idle;
	        }
	    }
	}
	
	private boolean isPerformingOtherAction() {
	    return playerAction == aimingUp || playerAction == aimingStraight || playerAction == aimingDown;
	}

	private void updateAnimationTick() {
		
		animationTick++;
		if(animationTick >= animationSpeed) {
			animationTick = 0;
			animationIndex++;
			if(animationIndex >= GetSpriteAmount(playerAction)) {
				animationIndex = 0;
			}
		}
		
	}
	
	public void setDirection(int direction) {
		this.playerDirection = direction;
		moving = true;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getPlayerAction() {
		return playerAction;
	}

	public void setPlayerAction(int playerAction) {
		this.playerAction = playerAction;
	}
	
	
	
}