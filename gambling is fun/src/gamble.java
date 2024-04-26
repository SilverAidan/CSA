public class gamble {
	public static void main(String[] args) {
		int munny = 0;
		int cherry = 0;
		for (int i=0; i<1000000; i++){
			munny -= 10;
			int roll1 = (int)(Math.random()*10);
			int roll2 = (int)(Math.random()*10);
			int roll3 = (int)(Math.random()*10);
			if (roll1<=2)
				cherry++;
			else if (roll2<=1)
				cherry++;
			else if (roll3<=0)
				cherry++;
			if (cherry == 3)
				munny+=50;	
			else if (cherry == 2)
				munny+=20;
			else if (cherry == 1)
				munny+=10;
		}
		System.out.println(munny);
	}
}
