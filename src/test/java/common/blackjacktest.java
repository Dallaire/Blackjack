package common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
	
	public void testPlayerScoreDisplay() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		player.printScore();
		String expected = "Player's Score: 19\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerScoreDisplay1() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printScore();
		String expected = "Dealer's Score: 19\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerScoreDisplay2() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,12));
		dealer.addCard(new Card(Suit.H,7));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printScore();
		String expected = "Dealer's Score: 17\r\n";
		assertEquals(expected, out.toString());
	}
	public void testDealerScoreDisplay3() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,1));
		dealer.addCard(new Card(Suit.C,13));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printScore();
		String expected = "Dealer's Score: 21\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testFileInput() {
		Game game = new Game();
		game.runFile();
		assertEquals("File", game.mode);
	}
	
	public void testConsoleInput() {
		Game game = new Game();
		game.runConsole();
		assertEquals("Console", game.mode);
	}
	
	public void testInputChoiceConsole() {
		Game game = new Game();
		InputStream in = new ByteArrayInputStream("c".getBytes());
		System.setIn(in);
		String choise = game.choise();
		assertEquals("C", choise);
	}
	public void testInputChoiceFile() {
		Game game = new Game();
		InputStream in = new ByteArrayInputStream("f".getBytes());
		System.setIn(in);
		String choise = game.choise();
		assertEquals("F", choise);
	}
	
	public void testDealPlayer() {
		Player player = new Player("Player");
		Deck deck = new Deck();
		player.deal(deck);
		player.deal(deck);
		assertEquals(2, player.getHand().size());
	}
	
	public void testDealDealer() {
		Player player = new Player("Dealer");
		Deck deck = new Deck();
		player.deal(deck);
		player.deal(deck);
		assertEquals(2, player.getHand().size());
	}
	
	public void testPlayerHit() {
		Player player = new Player("Player");
		Deck deck = new Deck();
		player.deal(deck);
		assertEquals(1, player.getHand().size());
	}
	
	public void testPlayerHitRepeated() {
		Player player = new Player("Player");
		Deck deck = new Deck();
		player.deal(deck);
		player.deal(deck);
		assertEquals(2, player.getHand().size());
	}
	
	public void testPlayerStand() {
		
	}
	
	public void testPlayerHandDisplay() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		player.printHand(false);
		String expected = "Player's cards: H10 H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testPlayerBust() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,12));
		player.addCard(new Card(Suit.H, 11));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Bust! Dealer wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealer16less() {
		Game game = new Game();
		Deck deck = new Deck();
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,6));
		game.takeTurnDealer(deck, dealer);
		assertEquals(3, dealer.getHand().size());
	}
	
	public void testDealerSoft17() {
		Game game = new Game();
		Deck deck = new Deck();
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,1));
		game.takeTurnDealer(deck, dealer);
		assertEquals(3, dealer.getHand().size());
	}
	
	public void testDealerHitRepeated() {
		Player dealer = new Player("Player");
		Deck deck = new Deck();
		dealer.deal(deck);
		dealer.deal(deck);
		assertEquals(2, dealer.getHand().size());
	}
	
	public void testDealerHandDisplayHidden() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printHand(true);
		String expected = "Dealer's cards: [hidden] H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerHandDisplayVisible() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,9));
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		dealer.printHand(false);
		String expected = "Dealer's cards: H10 H9 \r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerBust() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,10));
		dealer.addCard(new Card(Suit.H,12));
		dealer.addCard(new Card(Suit.H, 11));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Bust! Player wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testAceLow() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,10));
		player.addCard(new Card(Suit.H,9));
		player.addCard(new Card(Suit.H,1));
		assertEquals(20, player.getScore());
		
	}
	
	public void testAceHigh() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,1));
		assertEquals(11, player.getScore());
	}
	
	public void testTwoAces() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,1));
		assertEquals(12, player.getScore());
	}
	
	public void testAceHighToLow() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,9));
		player.addCard(new Card(Suit.C,10));
		assertEquals(20, player.getScore());
	}
	
	public void testTwoAcesLow() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,5));
		player.addCard(new Card(Suit.C,5));
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.C,1));
		assertEquals(12, player.getScore());
	}
	
	public void testJack() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.C, 11));
		assertEquals(10, player.getScore());
	}
	
	public void testQueen() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.C, 12));
		assertEquals(10, player.getScore());
	}
	
	public void testKing() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.C, 13));
		assertEquals(10, player.getScore());
	}
	
	public void testPlayerBlackjack() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.H,12));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.scoreInitial(dealer, player);
		String expected = "Blackjack! Player wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerBlackjack() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,1));
		dealer.addCard(new Card(Suit.H,12));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.scoreInitial(dealer, player);
		String expected = "Blackjack! Dealer wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	
	
	public void testPlayerBlackjackWin() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		player.addCard(new Card(Suit.H,1));
		player.addCard(new Card(Suit.H,12));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Blackjack! Player wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerBlackjackWin() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,1));
		dealer.addCard(new Card(Suit.H,12));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Blackjack! Dealer wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testPlayerScore() {
		Player player = new Player("Player");
		player.addCard(new Card(Suit.H,4));
		player.addCard(new Card(Suit.H,6));
		assertEquals(10, player.getScore());
	}
	
	public void testDealerScore() {
		Player dealer = new Player("Dealer");
		dealer.addCard(new Card(Suit.H,4));
		dealer.addCard(new Card(Suit.H,6));
		assertEquals(10, dealer.getScore());
	}
	
	public void testPlayerWin() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		player.addCard(new Card(Suit.H,8));
		player.addCard(new Card(Suit.H,12));
		dealer.addCard(new Card(Suit.H,7));
		dealer.addCard(new Card(Suit.H,11));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Player wins.\r\n";
		assertEquals(expected, out.toString());
	}
	
	public void testDealerWin() {
		Game game = new Game();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		player.addCard(new Card(Suit.H,6));
		player.addCard(new Card(Suit.H,12));
		dealer.addCard(new Card(Suit.H,7));
		dealer.addCard(new Card(Suit.H,11));
		
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.score(dealer, player);
		String expected = "Dealer wins.\r\n";
		assertEquals(expected, out.toString());
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
