package PigLatinLab;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PigLatinLab {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner to get user input
        Scanner console = new Scanner(System.in);
        
        // Ask the user for the input and output file names
        System.out.println("What file would you like to get words from (include .txt): ");                                
        String filein = console.next();
        System.out.println("What is the output file called (include .txt): ");
        String fileout = console.next();
 
        // Open the input and output files
        Scanner input = new Scanner(new File(filein));
        PrintWriter output = new PrintWriter(new File(fileout));
        
        // Process each word in the input file
        while (input.hasNext()) {
            String word = input.next();
            String pigLatinWord = piggy(word);
            output.print(pigLatinWord + " ");
        }
        // Close the output file
        output.close();
    }
    // This method converts a word to Pig Latin
    public static String piggy(String word) {
        int index = -1;
        String puncT = "";
        String beforePunc = "";
        final String Vow = "aeiouAEIOU";
        final String VowB = "haeiouyHAEIOUY";
        final String Punc = ".?!,";
        String finished;
        
        // Check for vowels in the word
        for (int i = 0; i < word.length(); i++) {
            if (Vow.indexOf(word.charAt(i)) >= 0) {
                index = i;
                beforePunc = word;
                break;
            }
        }
        // Check for punctuation in the word
        for (int i = 0; i < word.length(); i++) {
            if (Punc.indexOf(word.charAt(i)) >= 0) {
                puncT = word.substring(i);
                beforePunc = word.substring(0, i);
                break;
            }
        }
        // If there are no vowels, return "No vowels"
        if (index == -1) {
            return "No vowels";
        }
        // If the word starts with a vowel or 'y', add "way" to the end
        else if (VowB.indexOf(word.charAt(0)) >= 0) {
            return beforePunc + "way" + puncT;
        } else {
            // If the word starts with a consonant, move the consonants to the end and add "ay"
            if (Character.isUpperCase(word.charAt(0))) {
                beforePunc = beforePunc.toLowerCase();
                finished = beforePunc.substring(index) + beforePunc.substring(0, index) + "ay" + puncT;
                finished = Character.toUpperCase(finished.charAt(0)) + finished.substring(1);
            } else {
                finished = beforePunc.substring(index) + beforePunc.substring(0, index) + "ay" + puncT;
            }
        }
        return finished;
    }
}