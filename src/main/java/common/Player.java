package common;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player() {
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
			else
				score+= card.getValue();
		}
		
		while (score > 21 && aces > 0) {
			score -= 10;
			aces--;
		}
		
		return score;
	}
	
	public void printHand() {
		String output = "Player's cards: ";
		for (int i=0; i<this.hand.size(); i++) {
			output = output.concat(this.hand.get(i).toString() + " ");
		}
		System.out.println(output);
	}
}
