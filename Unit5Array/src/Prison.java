import java.util.Arrays;

public class Prison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prison = new int[100];
		
		for(int i = 0; i < prison.length; i++) {
			prison[i] = i;	
		}
		shuffle(prison);
		int count = 0;
		for(int i = 0; i < 1000000; i++) {
			shuffle(prison);
			if(runAll(prison)) {
				count++;
			}
			
		}
		System.out.println(count);
	}
	public static boolean runOne(int[] prison, int p) {
		int runner = p;
		for(int i = 0; i < (prison.length/2); i++) {
			if(prison[runner] == p)
				return true;
			else
				runner = prison[runner];
		}
		return false;
	}
	public static boolean runAll(int[] prison) {
		for(int prisoner:prison) {
			if(!runOne(prison,prisoner))
				return false;
		}
		return true;
	}
	
	public static void shuffle(int[] prison) {
		for(int i = 0; i < prison.length; i++) {
			int r = (int)(Math.random()*prison.length);
			int temp = prison[i];
			prison[i] = prison[r];
			prison[r] = temp;
		}
	}


}
