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
	
	public String toString(Card aCard) {
		String output = "";
		//suit
		if (aCard.cardSuit == Suit.C)		
			output = output.concat("C");
		else if (aCard.cardSuit == Suit.D)
			output = output.concat("D");
		else if (aCard.cardSuit == Suit.H)
			output = output.concat("H");
		else if (aCard.cardSuit == Suit.S)
			output = output.concat("S");
		
		//value
		switch(aCard.value) {
			case 1: output = output.concat("A");
			case 2: output = output.concat("2");
			case 3: output = output.concat("3");
			case 4: output = output.concat("4");
			case 5: output = output.concat("5");
			case 6: output = output.concat("6");
			case 7: output = output.concat("7");
			case 8: output = output.concat("8");
			case 9: output = output.concat("9");
			case 10: output = output.concat("10");
			case 11: output = output.concat("J");
			case 12: output = output.concat("Q");
			case 13: output = output.concat("K");
		}
		
		return output;
	}
}
