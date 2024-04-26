
public class BragDriver {

	public static void main(String[] args) {
		Hand Aidan = new Hand();
		Hand Jonah = new Hand();
		
		Card card1 = new Card(4, '♥');
		Card card2 = new Card(2, '♠');
		Card card3 = new Card(2, '♥');
		
		Card card4 = new Card(3, '♥');
		Card card5 = new Card(3, '♠');
		Card card6 = new Card(1, '♥');
		Aidan.Deal(card1, card2, card3);
		Jonah.Deal(card4, card5, card6);
		System.out.println(Aidan.Value());
		System.out.println(Jonah.Value());
		System.out.println(Aidan.compareTo(Jonah));
		System.out.println(card1.getRank());
	}

}
