package common;

import java.util.ArrayList;

public class Dealer {	

	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Dealer() {
		this.emptyHand();
	}
		
	public void emptyHand() {
		this.hand.clear();
	}
		
	public ArrayList<Card> getHand(){
		return this.hand;
	}
		
	public void addCard(Card aCard) {
		this.hand.add(aCard);
	}
		
	public int getScore() {
		int score = 0;
		for (Card card: this.hand) {
			if (card.getValue() > 10) {
				score += 10;
			}
			else
				score+= card.getValue();
		}
		return score;
	}
}


