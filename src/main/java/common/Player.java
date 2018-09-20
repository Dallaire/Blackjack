package common;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private String name;
	Boolean soft = false;
	
	public Player(String aName) {
		this.emptyHand();
		this.name = aName;
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
		int acesHand = 0;
		
		for (Card card: this.hand) {
			if (card.getValue() > 10) {
				score += 10;
			}
			else if (card.getValue() == 1) {
				score += 11;
				acesHand++;
			}
			else
				score+= card.getValue();
		}
		
		while (score > 21 && acesHand > 0) {
			score -= 10;
			acesHand--;
		}
		if (acesHand != 0)
			this.soft = true;
		
		return score;
	}
	
	public void deal(Deck aDeck) {
		//get top card
		Card newCard = aDeck.cards.remove(0);
		//add card to player hand
		this.addCard(newCard);
		if (newCard.getValue() == 1)
			this.soft = true;
	}
	
	public void printHand(Boolean hidden) {
		String output = this.name + "'s cards: ";
		for (int i=0; i<this.hand.size(); i++) {
			if (i == 0 && hidden == true)
				output = output.concat("[hidden] ");
			else
				output = output.concat(this.hand.get(i).toString() + " ");
		}
		System.out.println(output);
	}
	
	public void printScore() {
		System.out.println(name + "'s Score: " + this.getScore());
	}
}
