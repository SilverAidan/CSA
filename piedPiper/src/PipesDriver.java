import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PipesDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.println("What's the file called:");
		String fileName = console.next();
		Scanner fileReader = new Scanner(new File(fileName));
		Pipes mario = new Pipes(fileReader);
		mario.solve();
		System.out.println(mario);
		console.close();
	}

}
