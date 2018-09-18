package common;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		
		for (Suit suit : Suit.values()) {
			for (int i =1; i < 14; i++) {
				cards.add(new Card(suit, i));
			}
		}
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public void Shuffle() {
		Collections.shuffle(this.cards);
	}
}
