package common;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
		Deck deck = new Deck();
		deal(deck, player);
		deal(deck, player);
		assertEquals(2, player.getHand().size());
	}
	
	public void testDealDealer() {
		Player player = new Player();
		Deck deck = new Deck();
		deal(deck, player);
		deal(deck, player);
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
		Player player = new Player();
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		player.printHand(false);
		String expected = "Player's cards: H10 H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testPlayerBust() {
		
	}
	
	public void testDealer16less() {
		
	}
	
	public void testDealerSoft17() {
		
	}
	
	public void testDealerHitRepeated() {
		
	}
	
	public void testDealerHandDisplayHidden() {
		Player dealer = new Player();
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printHand(true);
		String expected = "Dealer's cards: [hidden] H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerHandDisplayVisible() {
		Player dealer = new Player();
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printHand(false);
		String expected = "Dealer's cards: H10 H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerBust() {
		
	}
	
	public void testAceLow() {
		Player player = new Player();
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,9));
		player.addCard(new Card(Suit.H,1));
		assertEquals(20, player.getScore());
		
	}
	
	public void testAceHigh() {
		Player player = new Player();
		player.addCard(new Card(Suit.H,1));
		assertEquals(11, player.getScore());
	}
	
	public void testTwoAces() {
		Player player = new Player();
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,1));
		assertEquals(12, player.getScore());
	}
	
	public void testAceHighToLow() {
		Player player = new Player();
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,9));
		player.addCard(new Card(Suit.C,10));
		assertEquals(20, player.getScore());
	}
	
	public void testTwoAcesLow() {
		Player player = new Player();
		player.addCard(new Card(Suit.H,5));
		player.addCard(new Card(Suit.C,5));
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,1));
		assertEquals(12, player.getScore());
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
		player.addCard(new Card(Suit.H,4));
		player.addCard(new Card(Suit.H,6));
		assertEquals(10, player.getScore());
	}
	
	public void testDealerScore() {
		Player dealer = new Player();
		dealer.addCard(new Card(Suit.H,4));
		dealer.addCard(new Card(Suit.H,6));
		assertEquals(10, dealer.getScore());
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
