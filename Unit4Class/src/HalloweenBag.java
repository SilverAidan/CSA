
public class HalloweenBag {
	private String candy1, candy2, candy3;
	private int count1, count2, count3;
	
	public HalloweenBag(String can1, String can2, String can3) {
		candy1 = can1; candy2 = can2; candy3 = can3;
	}
	public HalloweenBag(String can1) {
		candy1 = can1; candy2 = "none"; candy3 = "none";
	}
	
	public String lookInside() {
		String output = "";
		if (!candy1.equals("none"))
			output += candy1 + "--" + count1 + "\n";
		if (!candy2.equals("none"))
			output += candy2 + "--" + count2 + "\n";
		if (!candy3.equals("none"))
			output += candy3 + "--" + count3 + "\n";
		
		return output;
	}
	
	public void trickOrTreat() {
		if(!candy1.equals("none"))
			count1++;
		
		if(!candy2.equals("none"))
			count2++;
		
		if(!candy3.equals("none"))
			count3++;	
	}
	public boolean trickOrTreat(String candy) {
		if(candy1.equals(candy)) {
			count1++; return true;
		}
		if(candy2.equals(candy)) {
			count2++; return true;
		}
		if(candy3.equals(candy)) {
			count3++; return true;
		}
		return false;
		
	}
	
	public String eat() {
		int randoCandy = (int)(Math.random()*(count1+count2+count3));
		if (randoCandy < count1) {
			count1--;
			return candy1;
		}
		if (randoCandy < count1 + count2) {
			count2--;
			return candy2;
		}
		if (randoCandy < count1 + count2 + count3) {
			count3--;
			return candy3;
		}
		return "none";
	}
}
