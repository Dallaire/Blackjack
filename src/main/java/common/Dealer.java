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
	
	public void printHand(Boolean hidden) {
		String output = "Dealer's cards: ";
		for (int i=0; i<this.hand.size(); i++) {
			if (i == 0 && hidden == true)
				output = output.concat("[hidden] ");
			else
				output = output.concat(this.hand.get(i).toString() + " ");
		}
		System.out.println(output);
	}
}


