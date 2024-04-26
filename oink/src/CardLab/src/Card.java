
public class Card {
	private int rank;
	private char suit;
	public Card() {
		rank = (int)(Math.random()*12+2);
		int tempSuit = (int)(Math.random()*4);
		switch (tempSuit){
			case 0:
				suit = '♠';
				return;
			case 1:
				suit = '♥';
				return;
			case 2:
				suit = '♦';
				return;
			case 3:
				suit = '♣';
				return;
		}
	}
	public String toString() {
		String output =  "";
		output += this.getChar() + " of " + suit + "'s ";
		return output;
	}
	public char getChar(){
		char rankChar = (char)(rank + 48);
		switch (rank){
		case 10:
			rankChar = 'T';
			break;
		case 11:
			rankChar = 'J';
			break;
		case 12:
			rankChar = 'Q';
			break;
		case 13:
			rankChar = 'K';
			break;
		case 14:
			rankChar = 'A';
			break;
		}
		return rankChar;
	}
	public boolean getColor(){
		if (suit == '♥' || suit == '♦') {
			return true;
		}else {
			return false;
		}
	}
	public Card (Card other) {
		this.rank = other.rank;
		this.suit = other.suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public char getSuit() {
		return suit;
	}
	public void setSuit(char suit) {
		this.suit = suit;
	}

}
