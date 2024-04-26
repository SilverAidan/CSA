import java.util.ArrayList;

public class RayList {

	public static void main(String[] args) {
		ArrayList<Integer> carl =  new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			carl.add(i*i);
		}
		System.out.println(carl+"\n");
		
		for(int i = 0; i < carl.size(); i++) {
			if(carl.get(i)%2 == 1) {
				carl.remove(i);
				i--;
			}
		}
		System.out.println(carl+"\n");
		
		for(int i = 0; i < carl.size() - 1; i+=2) {
			carl.add(i+1, (carl.get(i) + carl.get(i+1))/2);
		}
		System.out.println(carl+"\n");
		
		ArrayList<Object> stuff = new ArrayList<Object>();
		String words[] = {"Snow", "days", "are", "cool"};
		for(String s : words) {
			stuff.add(s);
		}
		stuff.add(17);
		swap(stuff, 0, 4);
		System.out.println(stuff);
		
		System.out.println(countChar(stuff, 'a'));
		
		
		Marbles Bob = new Marbles(10);
		Marbles Alice = new Marbles(8);
		System.out.println(Bob.getMarbles());
		System.out.println(Alice.getMarbles());
		Bob.steal(2, Alice);
		System.out.println(Bob.getMarbles());
		System.out.println(Alice.getMarbles());
		Bob.trade(Alice, "Red", "Green");
		System.out.println(Bob.getMarbles());
		System.out.println(Alice.getMarbles());

	}
	
	public static int countChar(ArrayList<Object> list, char c) {
		int count = 0;
		for(Object obj:list) {
			if(obj instanceof String) {
				for(char cc : ((String)obj).toCharArray()) {
					cc = Character.toLowerCase(cc);
					if(c == cc) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void swap(ArrayList<Object> list, int i, int j) {
		Object temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	

}
