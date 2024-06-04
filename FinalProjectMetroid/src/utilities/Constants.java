package utilities;

public class Constants {

	public static class Directions{
		public static final int left = 0;
		public static final int up = 1;
		public static final int right = 2;
		public static final int down = 3;
	}
	
	public static class PlayerConstants{
		public static final int aimingUp = 0;
		public static final int aimingStraight = 3;
		public static final int aimingDown = 4;
		public static final int running = 1;
		public static final int idle = 2;
		public static final int jumping = 5;
		
		public static int GetSpriteAmount(int playerAction) {
			switch(playerAction) {
			case aimingUp:
				return 1;
			case aimingDown:
				return 1;
			case aimingStraight:
				return 1;
			case running:
				return 10;
			case jumping:
				return 10;
			case idle:
				return 1;
			default:
				return playerAction;
			}
			
		}
	}
}
