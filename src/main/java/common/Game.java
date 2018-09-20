package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	public String mode;
	
	public static void main(String[] args) {
		
	}
	
	public Game() {
		
	}
	
	public void runFile() {
		this.mode = "File";
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter file path");
		String filename = reader.nextLine();
		reader.close();
		
		//Initialize
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		
		try {
			FileReader filereader = new FileReader(filename);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line = bufferedreader.readLine();
			bufferedreader.close();
			String[] order = line.split(" ");
			
			Player active = player;
			
			for (int i=0; i< order.length; i++) {
				String str = order[i];
				int value = 0;
				if (i == 2 || i == 3) //sloppy handle it being dealer
					active = dealer;
				else if (i == 4) //back to player
					active = player;
				if (str.substring(0, 1) == "H") {
					if (str.length() < 2)
						continue;
					else
						value = getValue(str.substring(1));
					if (value == 0) {
						System.out.println("Invalid Input");
						break;
					}
					else
						active.addCard(new Card(Suit.H, value));
				}
				else if (str.substring(0, 1) == "C") {
					if (str.length() < 2) {
						System.out.println("Invalid Input");
						break;
					}
					else
						value = getValue(str.substring(1));
					if (value == 0) {
						System.out.println("Invalid Input");
						break;
					}
					else
						active.addCard(new Card(Suit.C, value));
				}
				else if (str.substring(0, 1) == "D") {
					if (str.length() < 2) {
						System.out.println("Invalid Input");
						break;
					}
					else
						value = getValue(str.substring(1));
					if (value == 0) {
						System.out.println("Invalid Input");
						break;
					}
					else
						active.addCard(new Card(Suit.D, value));
				}
				else if (str.substring(0, 1) == "S") {
					if (str.length() < 2) {
						active = dealer;
					}
					else
						value = getValue(str.substring(1));
					if (value == 0) {
						System.out.println("Invalid Input");
						break;
					}
					else
						active.addCard(new Card(Suit.C, value));
				}
				else
					System.out.println("Invalid Input");
			}
			
			player.printHand(false);
			player.printScore();
			dealer.printHand(false);
			dealer.printScore();
			
			score(dealer, player); //end of game
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("File unable to open");
		}
		catch(IOException ex) {
            System.out.println("Error reading file"); 
		}
	}
	
	public static int getValue(String str) {
		int value = 0;
		if (str.equals("A")) value = 1;
		else if (str.equals("2")) value = 2;
		else if (str.equals("3")) value = 3;
		else if (str.equals("4")) value = 4;
		else if (str.equals("5")) value = 5;
		else if (str.equals("6")) value = 6;
		else if (str.equals("7")) value = 7;
		else if (str.equals("8")) value = 8;
		else if (str.equals("9")) value = 9;
		else if (str.equals("10")) value = 10;
		else if (str.equals("J")) value = 11;
		else if (str.equals("Q")) value = 12;
		else if (str.equals("K")) value = 13;
		return value;
	}
	
	public void runConsole() {
		this.mode = "Console";
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
		player.printScore();
		dealer.printHand(true);
		
		//initial
		if (scoreInital(dealer, player) == false) {
			takeTurnPlayer(deck, player);
			takeTurnDealer(deck, dealer);
			score(dealer, player); //end of game
		}
	}
	
	public void takeTurnPlayer(Deck aDeck, Player aPlayer) {
		
	}
	
	public void takeTurnDealer(Deck aDeck, Player aDealer) {
		
	}
	
	public String choise() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter C for console F for file");
		String r = reader.nextLine();
		reader.close();
		r = r.toUpperCase();
		return r;
	}
	
	public void scoreInitial(Player aDealer, Player aPlayer) {
		
	}
	
	public void score(Player aDealer, Player aPlayer) {
		if (aDealer.getScore() == 21)
			System.out.println("Blackjack! Dealer wins.");
		else if (aPlayer.getScore() == 21)
			System.out.println("Blackjack! Player wins.");
		else if (aPlayer.getScore() > 21)
			System.out.println("Bust! Dealer wins.");
		else if (aDealer.getScore() > 21)
			System.out.println("Bust! Player wins.");
		else if (aDealer.getScore() == aPlayer.getScore())
			System.out.println("Even. Dealer wins.");
		else if (aDealer.getScore() > aPlayer.getScore())
			System.out.println("Dealer wins.");
		else if (aPlayer.getScore() > aDealer.getScore())
			System.out.println("Player wins.");
	}
	
}

