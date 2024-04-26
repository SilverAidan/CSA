
public class Hand {
	private Card card1, card2, card3;
	private int winBy = 1;
	public Hand() {
		card1 = new Card();
		card2 = new Card();
		card3 = new Card();
	}
	public Hand(Card card1, Card card2, Card card3) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
	}
	public String toString() {
		String output =  "";
		if (card1 == null)
			return "No cards in your hand";
		output += "A (" + card1 + ") a (" + card2 + ") & a (" + card3 + ")";
		return output;
	}
	public Hand Deal() {
		Hand newHand = new Hand();
		card1 = new Card();
		do {
	        card2 = new Card();
	        card3 = new Card();
		} while(card2.equals(card1) && card3.equals(card2) || card3.equals(card1));
		newHand.setCard1(card1);
	    newHand.setCard2(card2);
	    newHand.setCard3(card3);
		return newHand;
	}
	public void Deal(Card card1, Card card2, Card card3) {
	    this.card1 = card1;
	    this.card2 = card2;
	    this.card3 = card3;
	}
	public int highCard() {
	    int highNum = Math.max(Math.max(card1.getRank(), card2.getRank()), card3.getRank());
	    return highNum;
	}
	public String Value(){
		String valueStr = "";
		if (card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank()){
			valueStr += "Prial;" + this.highCard();
			winBy = 6;
			return valueStr;
		}
		else if (card1.getSuit() == (card2.getSuit()) && card1.getSuit() == (card3.getSuit())) {
			if (((this.highCard()*3) - 3) == (card1.getRank() + card2.getRank() + card3.getRank())) {
				valueStr += "Straight Flush;" + this.highCard();
				winBy = 5;
				return valueStr;
			}else {
				valueStr += "Flush;" + this.highCard();
				winBy = 3;
				return valueStr;
			}
		}
		
		else if ((this.highCard()*3) == (card1.getRank() + card2.getRank() + card3.getRank())){
			valueStr += "Straight;" + this.highCard();
			winBy = 4;
			return valueStr;
		}
		
		else if (card1.getRank() == card2.getRank() || card1.getRank() == card3.getRank() || card2.getRank() == card3.getRank()) {
			if(card1.getRank() == card2.getRank() || card1.getRank() == card3.getRank()) {
				valueStr += "Pair;" + card1.getChar();
			}
			else if(card2.getRank() == card3.getRank()){
				valueStr += "Pair;" + card2.getChar();
			}
			winBy = 2;
			return valueStr;
		}
		
		else {
			valueStr += "High Card;" + this.highCard();
			winBy = 1;
			return valueStr;
		}
	}
	
	public void Fold() {
		card1 = null;
		card2 = null;
		card3 = null;
	}
	
	public boolean equals(Hand hand1){
		boolean equals = false;
		if (this.card1.getRank() + this.card2.getRank() + this.card3.getRank() == hand1.card1.getRank() + hand1.card2.getRank() + hand1.card3.getRank()) {
			equals = true;
		}
		return equals;
	}
	
	public int compareTo(Hand other){
		this.Value();
		other.Value();
		int winAmount = this.winBy - other.winBy;
		if (winAmount == 0) {
			if (this.highCard() > other.highCard()) {
				winAmount = 10;
			}
			else if (this.highCard() > other.highCard()) {
				winAmount = -10;
			}
			else if ((this.card1.getColor() == this.card2.getColor() && this.card1.getColor() == this.card3.getColor()) && (other.card1.getColor() == other.card2.getColor() && other.card1.getColor() == other.card3.getColor())) {
				winAmount = 0;
			}
			else if(this.card1.getColor() == this.card2.getColor() && this.card1.getColor() == this.card3.getColor()) {
				winAmount = 10;
				return winAmount;
			}
			else if (other.card1.getColor() == other.card2.getColor() && other.card1.getColor() == other.card3.getColor()) {
				winAmount = -10;
				return winAmount;
			}
			else {
				winAmount = 0;
				return winAmount;
			}
		}
		return winAmount;
	}
	
	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public Card getCard3() {
		return card3;
	}

	public void setCard3(Card card3) {
		this.card3 = card3;
	}
}
