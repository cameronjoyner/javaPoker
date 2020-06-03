//Cameron Joyner
//CGJ2115
//GAME ACTUALLY PLAYED HERE

import java.util.Scanner;
import java.util.ArrayList;

// add your own banner here

public class Game {
	
	private boolean taInput;
	private Player p;
	private Deck cards;
	public  Scanner pokerScanner = new Scanner(System.in);   //make private
	public  Scanner pokerScannerTwo = new Scanner(System.in);
	public  Scanner pokerScannerThree = new Scanner(System.in);
	public  Scanner pokerScannerFour = new Scanner(System.in);   //make private
	private Card[] playerHand = new Card[5];
	private Boolean playerAnswer = true;
	
	public Game(String[] testHand){

		//this is a constructor to test the code 

		taInput = true;
		p = new Player();

		cards = new Deck();

		for(int i = 0; i<5; i++){

			String testHandSuit = testHand[i].substring(0,1);
			int suit = 0;

			if(testHandSuit.equals("h")){
				suit = 1;
			} else if(testHandSuit.equals("d")){
				suit = 2;
			} else if(testHandSuit.equals("c")){
				suit = 3;
			} else {
				suit = 4;
			}

			int rank = Integer.parseInt(testHand[i].substring(1));
			p.addCard(new Card(suit,rank));

		}

		//p.showHand();

		//System.out.println();
		//p.handValue();



		

		
	}
	
	public Game(){
		p = new Player(); 
		cards = new Deck();
		startNewGame();
		taInput = false;
	}

	public void startNewGame(){

		cards.shuffle();

	}
	
	public void play(){
		
		welcomeMessage();

		startNewGame();

		while(playerAnswer == true && p.getBankroll() > 0){

		playersBet();

			if(!taInput){

				for(int i = 0; i < 5; i++){ //deals a card five times
				
					p.addCard(cards.deal());
				
				}
			}

		System.out.println("Here's your hand:");
		p.showHand();

		System.out.println();
		p.handValue();

		System.out.println();
		System.out.println();



		int escapeWhileLoop = -2;

		while(escapeWhileLoop < 0){	

			try{

				System.out.println("How many cards would you like to replace?");
				System.out.println("You can replace any number of them (0-5)");

				System.out.println();

				int playersReplacement = pokerScanner.nextInt();	

				if(playersReplacement == 0){

					System.out.print("Well alright then Mr.Confident");
					escapeWhileLoop = 1;
				
				} else if (playersReplacement > 5 || playersReplacement < 0){

					System.out.println("Try a good number dude!");
					escapeWhileLoop = -1;

				} else { //should we build contengency for 

					for(int i = 0; i < playersReplacement; i++ ){

						p.showReplacementOptions();

						System.out.println
						("Type the number of the card you'd like to replace (0-5)");

						int input = pokerScannerFour.nextInt();
						
						p.replace(input);

						System.out.println("Refreshing your deck now");
						escapeWhileLoop = 1;

					}
				}

				for(int i = 0; i < playersReplacement; i++ ){ 

				p.addCard(cards.deal());

				}


			}
			catch (Exception e){
            	System.out.println
            	("Was that a number?? Please enter Numbers.");
            	pokerScanner.next();
            }


		}




		System.out.println();
		System.out.println("Here's your final hand, you rambuxious gambler!");
		p.showHand();
		System.out.println();


		p.handValue();
		p.payout();

		if(p.getBankroll() > 0){

		System.out.println
		("Now it's up to you... Should we play again? YES or NO");

		Object playerPlaysAgain = pokerScannerTwo.next();

			if(playerPlaysAgain.equals("YES") || playerPlaysAgain.equals("y") 
				|| playerPlaysAgain.equals("yes") || playerPlaysAgain.equals("Yes") 
				|| playerPlaysAgain.equals("si") || playerPlaysAgain.equals("Si")) {

			//p.clear();
			reset();
			playerAnswer = true;
			

			//PICK UP HERE


			//p.removeCard(hand.get(0));
			//p.removeCard(1)

			} else {

			System.out.println("Ok thanks for playing!");
			playerAnswer = false;

			}	

		} else {

		System.out.println
		("You're out of money you stinkin bum. You can't play again.");

		}
	}


	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		return hand.toString();

		
	}

	public void reset(){

		for(int i = 0; i < 5; i++){

	        p.removeCard(0);

        }
        taInput = false;

	}

	public void welcomeMessage(){

		System.out.println();

		System.out.println("Welcome to the amazing world of Video Poker!");
		System.out.println("Let's start by dealing you five cards! Get ready!");
		System.out.println("Your current bankroll is " + p.getBankroll());
		System.out.println();

		int playerReady = -2;

		while(playerReady < 0){ //this will let us keep asking if they don't type some form of yes or no

		System.out.println("Are you ready to play? YES or NO");

		String playerReadyAnswer = pokerScannerThree.next();



			if (playerReadyAnswer.equals("YES") || playerReadyAnswer.equals("y") 
				|| playerReadyAnswer.equals("yes") || playerReadyAnswer.equals("Yes") 
				|| playerReadyAnswer.equals("si") || playerReadyAnswer.equals("Si")) {
				
				playerAnswer = true;
				playerReady = 1;

			} else if (playerReadyAnswer.equals("NO") || playerReadyAnswer.equals("No") 
				|| playerReadyAnswer.equals("no") || playerReadyAnswer.equals("N") 
				|| playerReadyAnswer.equals("n")){

				System.out.println("That's ok! Read a book on poker and come back later");
				playerAnswer = false;
				playerReady = 0;	

			} else {

				System.out.println("You didn't type 'yes' OR 'no' - so what the heck!");

				playerReady = -1;

			}
		}

	}

	public void playersBet(){

		Scanner pokerScanner = new Scanner(System.in);	

		int escapeBetLoop = -2;

		while(escapeBetLoop < 0){	

			try{

			System.out.println("How much would you like to bet between 1 and 5?");
			int playersBet = pokerScanner.nextInt();

			if(playersBet <= 5 && playersBet >= 1 && playersBet <= p.getBankroll()){

				p.bets(playersBet);
				System.out.println("Thanks for gambling! Thats a safe habit to practice!");
				System.out.println("Your current bankroll is " + p.getBankroll());

				System.out.println();
				//int playersBet = pokerScanner.nextInt();
				//playersBet = pokerScanner.nextInt();
				escapeBetLoop = 1;

			} else if(playersBet > p.getBankroll() || playersBet < p.getBankroll() 
				|| playersBet < 0 || playersBet > 5){

				System.out.println("You can't bet that much! I said 1 - 5");
				System.out.println();
				//int playersBet = pokerScanner.nextInt();
				//playersBet = pokerScanner.nextInt();
				escapeBetLoop = -1;

			} else {

				System.out.println
				("Hmmmm Let's try again");
				escapeBetLoop = -2;
			}

			}

			catch (Exception e){
            	System.out.println
            	("Was that a number?? Please enter Numbers. ");
            	pokerScanner.next();
        	}
        }

		}
		

	

}




