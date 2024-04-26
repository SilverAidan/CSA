import java.util.Scanner;
public class CrapsLab {

	public static void main(String[] args) {
		Scanner console;
		console = new Scanner(System.in);
		
		// Prompt the user if they want to gamble or not
		System.out.println("You wanna test your luck and kiss your money goodbye? 1 yes 2 no: ");
		byte gamble = console.nextByte();
		
		if (gamble != 1)
			System.out.println("bye");
		else {
			// Ask the user how much money they have
			System.out.println("How much do you have?: ");
			double cashMoney = console.nextDouble();
			if (cashMoney < 0) 
				System.out.println("Get out! WE need CASH (What happened to our stash)");
			
			// Ask the user how much they want to bet
			System.out.println("How much are you betting?: ");
			double betAmount = console.nextDouble();
			if (cashMoney < 0) 
				System.out.println("Get out! WE need CASH (What happened to our stash)");
			
			int dice1 = (int)(Math.random()* 6 + 1);
			int dice2 = (int)(Math.random()* 6 + 1);
			int roll = dice1 + dice2;
			while (cashMoney > 0) {
				// Use a switch statement to handle different rolls
				switch (roll) {
					case 7:
					case 11:
						cashMoney = cashMoney + betAmount;
						System.out.println("You win, you got back double what you bet! ");
					case 2:
					case 3:
					case 12:
						cashMoney = cashMoney - betAmount;
						System.out.println("You lose :/ ");
					default:
						
				}
			}
		}
		console.close();
	}
}
