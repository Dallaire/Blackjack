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
		int aces = 0;
		
		for (Card card: this.hand) {
			if (card.getValue() > 10) {
				score += 10;
			}
			else if (card.getValue() == 1) {
				score += 11;
				aces++;
			}
			else {
				score+= card.getValue();
			}
		}
		
		while (score > 21 && aces > 0) {
			score -= 10;
			aces--;
		}
		
		return score;
	}
}


