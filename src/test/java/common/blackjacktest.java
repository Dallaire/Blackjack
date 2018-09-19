package common;

import junit.framework.TestCase;

public class blackjacktest extends TestCase {
	
	public void testCreateDeck() {
		Deck deck = new Deck();
		assertEquals(52, deck.getSize());
	}
	
	public void testShuffle() {
		Deck shuffledeck = new Deck();
		Deck unshuffleddeck = new Deck();
		shuffledeck.Shuffle();
		assertFalse(shuffledeck.cards.equals(unshuffleddeck.cards));
	}
	
	
	public void testFileInput() {
		
	}
	
	public void testConsoleInput() {
		
	}
	
	public void testInputChoice() {
		
	}
	
	public void testDealPlayer() {
		Player player = new Player();
		player.deal();
		assertEquals(2, player.getHand().size());
	}
	
	public void testPlayerVisibleCards() {
		
	}
	
	public void testDealerVisibleCards() {
		
	}
	
	public void testPlayerHit() {
		
	}
	
	public void testPlayerHitRepeated() {
		
	}
	
	public void testPlayerStand() {
		
	}
	
	public void testPlayerHandDisplay() {
		
	}
	
	public void testPlayerBust() {
		
	}
	
	public void testDealer16less() {
		
	}
	
	public void testDealerSoft17() {
		
	}
	
	public void testDealerHitRepeated() {
		
	}
	
	public void testDealerHandDisplay() {
		
	}
	
	public void testDealerBust() {
		
	}
	
	public void testAceLow() {
		
	}
	
	public void testAceHigh() {
		
	}
	
	public void testTwoAces() {
		
	}
	
	public void testAceHighToLow() {
		
	}
	
	public void testTwoAcesLow() {
		
	}
	
	public void testJack() {
		Player player = new Player();
		player.addCard(new Card(Suit.C, 11));
		assertEquals(10, player.getScore());
	}
	
	public void testQueen() {
		Player player = new Player();
		player.addCard(new Card(Suit.C, 12));
		assertEquals(10, player.getScore());
	}
	
	public void testKing() {
		Player player = new Player();
		player.addCard(new Card(Suit.C, 13));
		assertEquals(10, player.getScore());
	}
	
	public void testPlayerBlackjack() {
		
	}
	
	public void testDealerBlackjack() {
		
	}
	
	public void testPlayerBlackjackWin() {
		
	}
	
	public void testDealerBlackjackWin() {
		
	}
	
	public void testPlayerScore() {
		Player player = new Player();
		Deck deck = new Deck();
		player.addCard(new Card(Suit.H,4));
		player.addCard(new Card(Suit.H,6));
		asserEquals(10, player.getScore());
	}
	
	public void testDealerScore() {
		
	}
	
	public void testPlayerWin() {
		
	}
	
	public void testDealerWin() {
		
	}
	
	public void testPlayerSplit() {
		
	}
	
	public void testDealerSplit() {
		
	}
	
	public void testPlayerSplitHit() {
		
	}
	
	public void testDealerSplitHit() {
		
	}
	
	public void testPlayerSplitBestHand() {
		
	}
	
	public void testDealererSplitBesthand() {
		
	}
	
	public void testSplitWinner() {
		
	}
	

}
