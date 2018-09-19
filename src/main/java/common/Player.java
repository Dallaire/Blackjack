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
}
