
public class ElmStreet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HalloweenBag Freddy = new HalloweenBag("Snickers", "M&M's", "KitKats");
		HalloweenBag Jason = new HalloweenBag("Yorks");
		HalloweenBag Chucky = Freddy;
		System.out.println(Chucky.getClass());
		System.out.println(Freddy.lookInside());
		System.out.println(Jason.lookInside());
		
		Freddy.trickOrTreat("Snickers");Freddy.trickOrTreat("Snickers");
		Freddy.trickOrTreat("M&M's");
		for (int i = 0; i < 3; i++) {
			Freddy.trickOrTreat();
			Jason.trickOrTreat();
		}
		System.out.println(Freddy.lookInside());
		System.out.println(Jason.lookInside());
		
		if(Freddy.trickOrTreat("Yorks")) {
			System.out.println("Happy Halloween");
		}else
			System.out.println("I'll see you in your nightmares");
		
		if(Jason.trickOrTreat("Yorks")) {
			System.out.println("Go Whalers");
		}else
			System.out.println("I'll slash you later");
		
		for(int i = 0; i < 15; i++) {
			System.out.println(Freddy.eat());
		}
		
		VroomVroom sketchyVan = new VroomVroom();
		VroomVroom schoolBus = new VroomVroom();
		VroomVroom tesla = new VroomVroom();
		System.out.println(sketchyVan);
		System.out.println(schoolBus);
		
		Garage GHS = new Garage(sketchyVan, schoolBus, tesla, "Hubbard");
		
		GHS.getCar3().move(100);
		System.out.println(GHS);
	}

}
