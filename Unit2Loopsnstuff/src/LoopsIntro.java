import java.util.Scanner;

public class LoopsIntro {

	public static void main(String[] args) {
		int n = 6;
		int fingers = 0;
		int sequence = 0;
		int sum = 0;
		while (fingers < n) {
			sum = sum + sequence;
			fingers++;
			sequence = sequence + fingers;
		}
		System.out.println(sum);	
		for(int i = 0;i<n;i++) {
			sum = sum+sequence;
			sequence+=i;
		}
		Scanner console = new Scanner(System.in);
		int response;
		//at least once loop
		do {
			System.out.println("Stuff");
			System.out.println("Press 1 for more stuff ");
			response = console.nextInt();
		}while(response==1);
		System.out.println("What season is it? 1 Winter etc");
		int season = console.nextInt();
		switch(season) {
		case 1://winter
			System.out.println("Do you wanna build a snowman");
			break;
		case 2://spring
			System.out.println("April showers bring may flowers");
			break;
		case 3:
			System.out.println("CAMP TIME");
			break;
		case 4:
			System.out.println("Sweater Weather");
			break;
		default:
			System.out.println("liar thats cap");
		}
	}

}
