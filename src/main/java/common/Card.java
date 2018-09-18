package common;

public class Card {
	
	private Suit cardSuit;
	//Ace =1, j-K = 11-13
	private int value;

	public Card(Suit aSuit, int aValue) {
		this.cardSuit = aSuit;
		this.value = aValue;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Suit getSuit() {
		return this.cardSuit;
	}
	
	public String toString() {
		String crdStr = "";
		crdStr += this.cardSuit;
		
		if(this.value == 1) {
			crdStr += 'A';
		}
		else if (this.value == 11) {
			crdStr += 'J';
		}
		else if (this.value == 12) {
			crdStr += 'Q';
		}
		else if (this.value == 13) {
			crdStr += 'K';
		}
		else {
			crdStr += value;
		}
		
		return crdStr;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Card) {
			Card card = (Card) o;
			if (this.cardSuit == card.cardSuit && this.value == card.value) {
				return true;
			}
		}
		return false;
	}
}
