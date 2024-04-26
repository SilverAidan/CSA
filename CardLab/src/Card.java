
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
		output += this.getChar() + " of " + suit + "'s";
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
		case 'T':
		case 'J':
		case 'Q':
		case 'K':
		case 'A':
			rankChar = (char)rank;
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
	public Card(int rank, char suit) {
	    this.rank = rank;
	    this.suit = suit;
	}
	public Card(char rank, char suit) {
	    this.rank = rank;
	    this.suit = suit;
	}
	public int getRank() {
		if (rank >= 2 && rank <= 9) {
	        return rank; 
		}else {
			switch (rank) {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
            	return -1;
		    }
	    }
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
