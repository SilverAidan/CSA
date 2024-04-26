import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("How old are you ");
		
		int age;//declaring a variable
		Scanner console;
		console = new Scanner(System.in);
		age = console.nextInt();
		console.nextLine();//flushing the console
		
		//System.out.println(age);
		double cash;
		System.out.println("How much you holding ");
		cash = console.nextDouble();
		console.nextLine();
		
		String name;
		System.out.println("By what do you call your personage ");
		name = console.nextLine();
		System.out.println("Nice to meet you, " + name + ". even though you are " 
		+ age + " years old, give me your $" + cash);
	}

}
