import java.util.Arrays;

public class Sunshine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		int[] numbers;
		numbers = new int[5];
		System.out.println(numbers);
		System.out.println(numbers[0]);
		System.out.println(numbers.length);
		int sevens[] = new int[10];
		for(int i = 0; i < sevens.length; i++) {
			sevens[i] = (i+1) * 7;
		}
		System.out.println(Arrays.toString(sevens));
		String[] pies = new String[] {"pumpkin", "pecan", "apple", "key lime"};
		int countP = 0;
		for(int i = 0; i < pies.length; i++) {
			for(int j = 0; j < pies[i].length(); j++) {
				if (pies[i].charAt(j) == 'p') {
					countP++;
				}
			}
		}
		System.out.println(countP);
		for (int seven:sevens)
			System.out.println(seven);
		countP = 0;
		for (String pie:pies) {
			for (char c:pie.toCharArray()) {
				if (c == 'p')
					countP++;
			}
		}
		System.out.println(countP);
		Words Thanksgiving = new Words(pies);
		Thanksgiving.addWord("rhubarb");
		System.out.println(Arrays.toString(Thanksgiving.getWords()));
		Thanksgiving.cycle();
		System.out.println(Arrays.toString(Thanksgiving.getWords()));
	}

}
