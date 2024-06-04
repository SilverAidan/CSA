package entities;

import static utilities.Constants.PlayerConstants.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static utilities.Helpers.*;
import java.io.IOException;

import main.GameLoop;
import utilities.loadnsave;
import static utilities.Helpers.CanMoveHere;

public class Samus extends Entity{
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 20;
	private int playerAction = idle;
	private boolean moving = false, shooting = false;
	private boolean left, up, right, down, jump;
	private float playerSpeed = 2.0f * GameLoop.scale;
	private int[][] levelData;
	private float xDrawOffset = 0 * GameLoop.scale;
	private float yDrawOffset = 8 * GameLoop.scale;
	
	//jumping
	private float airSpeed = 0f;
	private float gravity = 0.04f * GameLoop.scale;
	private float jumpSpeed = -2.25f * GameLoop.scale;
	private float fallSpeedCollision = 0.5f * GameLoop.scale;
	private boolean inAir = false;
			

	public Samus(float x, float y, int width, int height) throws IOException {
	    super(x, y, width, height);
	    loadAnimations();
	    initHitbox(x, y, (int)(20 * GameLoop.scale),(int)(28 * GameLoop.scale)); 
	}
	
	private void loadAnimations() throws IOException {
		BufferedImage sprite = loadnsave.getSpriteAtlas(loadnsave.playerAtlas);
		animations = new BufferedImage[6][10];
		
		animations[aimingUp][0] = sprite.getSubimage(56, 39, 28, 37);
		animations[aimingStraight][0] = sprite.getSubimage(28, 38, 28, 37);
		animations[aimingDown][0] = sprite.getSubimage(0, 38, 28, 37);
		animations[idle][0] = sprite.getSubimage(28, 38, 28, 37);
		
		for(int i = 0; i < 10; i++) {
			animations[running][i] = sprite.getSubimage(30*i, 0, 30, 37);
			animations[jumping][i] = sprite.getSubimage(33*i, 86, 33, 28);
		}	
	}
	
	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
		if (!Floored(hitbox, levelData))
			inAir = true;
	}
	
	public void update() {
		updatePosition();
		updateAnimationTick();
		setAnimation();
	}
	
	public void render(Graphics g, int xLevelOffset) {
		g.drawImage(animations[playerAction][animationIndex], (int) (hitbox.x - xDrawOffset) - xLevelOffset, (int) (hitbox.y - yDrawOffset), width, height, null);
		//drawHitbox(g);
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
	    if (inAir) {
			if (airSpeed < 0)
				playerAction = jumping;
			else
				playerAction = idle;
		}
//	    
//	    if(shooting) {
	    	//shoot placeholder
	    	//playerAction = idle;
//	    }
	}
	
	private void updatePosition() {
		moving = false;

		if (jump)
			jump();

		if (!inAir)
			if ((!left && !right) || (right && left))
				return;

		float xSpeed = 0;

		if (left)
			xSpeed -= playerSpeed;
		if (right)
			xSpeed += playerSpeed;

		if (!inAir)
			if (!Floored(hitbox, levelData))
				inAir = true;

		if (inAir) {
			if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, levelData)) {
				hitbox.y += airSpeed;
				airSpeed += gravity;
				updateXPos(xSpeed);
			} else {
				hitbox.y = GetEntityYRoof(hitbox, airSpeed);
				if (airSpeed > 0)
					resetInAir();
				else
					airSpeed = fallSpeedCollision;
				updateXPos(xSpeed);
			}

		} else
			updateXPos(xSpeed);
		moving = true;
	}
	
	private void jump() {
	    if (inAir)
	        return;
	    inAir = true;
	    airSpeed = jumpSpeed;
	}

	private void resetInAir() {
	    inAir = false;
	    airSpeed = 0; 
	}

	private void updateXPos(float xSpeed) {
		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, levelData)) {
			hitbox.x += xSpeed;
		} else {
			hitbox.x = GetEntityXWall(hitbox, xSpeed);
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

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
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