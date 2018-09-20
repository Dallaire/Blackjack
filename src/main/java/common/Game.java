package common;

public class Game {

	public static void main(String[] args) {
		//Initialize
		Deck deck = new Deck();
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		
		//deal cards
		player.deal(deck);
		dealer.deal(deck);
		player.deal(deck);
		dealer.deal(deck);
		
		//print starting hands
		System.out.println("Starting Hands");
		player.printHand(false);
		dealer.printHand(true);
	}
	
	public void runFile() {
		
	}
	
	public void runConsole() {
		
	}
	
	public void chooseRunType() {
		
	}
	
	public void run() {
		
	}
}

