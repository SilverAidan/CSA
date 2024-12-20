
public class Zoo {

	public static void main(String[] args) {
		Bear Pooh = new Bear();
		Panda Po = new Panda();
		System.out.print(Po.eat());
		KungFuPanda Jack = new KungFuPanda();
		System.out.println(Po.eat());
		
		Bear[] bears = new Bear[4];
		bears[0] = Pooh; bears[1] = Po; bears[2] = Jack; bears[3] = new Bear();
		
		for(Bear b:bears) {
			if(b instanceof KungFuPanda) {
				System.out.println(((KungFuPanda)b).speak(3));
			}else {
				System.out.println(b.speak());
			}
		}
		for(Bear b:bears) {
			System.out.println(Jack.bearBattle(b));
		}
	}

}
