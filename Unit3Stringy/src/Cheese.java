
public class Cheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		String str = "Friday's are awesome";
		String str2 = str;//not more date
		int y = x;
		String str3;
		System.out.println(str.length());//6
		System.out.println(str.charAt(1));//r
		System.out.println(str.indexOf('r'));
		System.out.println(str.indexOf('r',2));
		
		String subset = str.substring(3,6);
		System.out.println(subset);
		
		int alphaDiff = "zoo".compareTo("alphabet");
		System.out.println(alphaDiff);
		String word = "yellow";
		System.out.println(ceaserCypher(word, 3));
		
		String sentence = "Its only tuesday, i dont eat pizza today";
		System.out.println(lossyCompression(sentence));
	}
	public static String ceaserCypher(String stuff, int shift) {
		String output = "";
		for (int i = 0; i<stuff.length();i++) {
			char c = stuff.charAt(i);
			c = shiftLetter(c,shift);
			output += c;
		}
		return output;
	}
	public static char shiftLetter(char c, int shift) {
		c += shift;
		if (c >'z'){
			c = (char)(c - 'z'-1+'a');
		}
		return c;
	}
	public static String lossyCompression(String str) {
		String vowels = "aeiouAEIOU";
		String output = "";
		for (int i = 0; i<str.length();i++) {
			char c= str.charAt(i);
			if(vowels.indexOf(c)==-1)//not a vowel
				output += c;
		}
		return output;
	}

}
