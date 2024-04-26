import java.util.Scanner;

public class EasyStickGame {

	public static void main(String[] args) {
		int sticks = 20;
		int playerMove, aiMove;
		Scanner input = new Scanner(System.in);
		while (sticks > 0) {
			System.out.println("Your move");
			playerMove = input.nextInt();
			sticks -= playerMove;
			if(sticks == 1) {
				System.out.println("You are a winner g");
				sticks = 0;
			}else {
				aiMove = (sticks-1)%4;
				if(aiMove == 0) {
					aiMove = 1;
				}
				System.out.println("AI Takes " + aiMove);
				sticks -= aiMove;
				if (sticks == 1) {
					System.out.println("You lost to 29 lines of code");
					sticks = 0;
				}
			}
		}
		input.close();
	}
}
