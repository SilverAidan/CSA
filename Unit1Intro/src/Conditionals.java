import java.util.Scanner;

public class Conditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age;
		Scanner anything = new Scanner(System.in);
		System.out.print("How old are you");
		age = anything.nextInt();
		boolean isCitizen;
		System.out.print("Are you a citizen");
		isCitizen = anything.nextBoolean();
		if (age <= 18 && isCitizen){//boolean goes in there
			System.out.println("Make sure you vote");
		}else {//optional
			System.out.println("Sorry champ, youre too young");
		}
	}

}
