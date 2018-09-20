package common;

import java.util.Scanner;

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
	
	public Game() {
		
	}
	public void runFile() {
		
	}
	
	public void runConsole() {
		
	}
	
	
	public String choise() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter C for console F for file");
		String r = reader.nextLine();
		reader.close();
		r = r.toUpperCase();
		return r;
	}
}

