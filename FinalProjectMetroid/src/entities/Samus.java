package entities;

import static utilities.Constants.PlayerConstants.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import utilities.loadnsave;

public class Samus extends Entity{
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 20;
	private int playerAction = idle;
	private boolean moving = false, shooting = false;
	private boolean left, up, right, down;
	private float playerSpeed = 2.0f;

	public Samus(float x, float y, int width, int height) throws IOException {
		super(x, y, width, height);
		loadAnimations();
	}
	
	private void loadAnimations() throws IOException {
		BufferedImage sprite = loadnsave.getSpriteAtlas(loadnsave.playerAtlas);
		animations = new BufferedImage[5][10];
		for(int i = 0; i < 1; i++) {
			animations[aimingUp][i] = sprite.getSubimage(56, 39, 28, 37);
			animations[aimingStraight][i] = sprite.getSubimage(28, 38, 28, 37);
			animations[aimingDown][i] = sprite.getSubimage(0, 38, 28, 37);
			animations[idle][i] = sprite.getSubimage(28, 38, 28, 37);
		}
		for(int i = 0; i < 10; i++) {
			animations[running][i] = sprite.getSubimage(30*i, 0, 30, 37);
		}	
	}
	
	public void update() {
		updatePosition();
		updateAnimationTick();
		setAnimation();
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][animationIndex], (int) x, (int) y, 54, 72, null);
	}

	public void setPlayerAction(int action) {
		this.playerAction = action;
	}
	private void updateAnimationTick() {
	    animationTick++;
	    if (animationTick >= animationSpeed) {
	        animationTick = 0;
	        animationIndex++;
	        if (animationIndex >= GetSpriteAmount(playerAction)) {
	            animationIndex = 0;
	            shooting = false;
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
	    
	    if(shooting) {
	    	//shoot placeholder
	    	//playerAction = idle;
	    }
	}
	
	private void updatePosition() {
		moving = false;
		
		if(left && !right){
			x -= playerSpeed;
			moving = true;
		}else if(right && !left){
			x+= playerSpeed;
			moving = true;
		}
		
		if(up && !down){
			y -= playerSpeed;
			moving = true;
		}else if(down && !up){
			y += playerSpeed;
			moving = true;
		}
	}
	
	private boolean isPerformingOtherAction() {
	    return playerAction == aimingUp || playerAction == aimingStraight || playerAction == aimingDown;
	}
	
	public void resetDirBooleans() {
		right = false;
		left = false;
		up = false;
		down = false;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	

}