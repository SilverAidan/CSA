import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MoreStrings {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(bla("Hello World"));
		Scanner console = new Scanner(System.in);
		Scanner fileReader = new Scanner(new File("numbers.txt"));
		int sum = 0; int count = 0;
		PrintWriter fileWriter = new PrintWriter(new File("cleanData.txt"));
		while(fileReader.hasNext()) {
			int weight = fileReader.nextInt();
			if(weight>0) {
				sum+=weight;count++;
				fileWriter.print(weight + " ");
			}
		}
		fileWriter.close();fileReader.close();
		
		System.out.println("Average ball " + 1.0*sum/count);
		
		fileReader = new Scanner (new File("MeetingTalk.txt"));
		fileWriter = new PrintWriter(new File("BlaTalk.txt"));
		while(fileReader.hasNext()) {
			String word =fileReader.next();
			fileWriter.print(bla(word)+ " ");
		}
		fileReader.close();fileWriter.close();
	}
	public static String bla(String str) {
		String output = ""; String helper = "bla";
		for(int i = 0; i<str.length();i++){
			//output+=helper.charAt(i%3);
			switch(i%3) {
			case 0:
				output+='b'; break;
			case 1:
				output += 'l'; break;
			default:
				output += 'a';
			}		
		}
		return output;
	}

}