//Cameron Joyner
//CGJ2115
//PLAYER CREATED 
//CARDS EVALUATED  
//WINNINGS DISTRIBUTED 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player {
	
	
	private ArrayList<Card> hand = new ArrayList<Card>(); // the player's cards
	private double bankroll;
    private double bet;
    private int replace;
    private int payout;

		
	public Player(){		
	    bet = 0;
	    bankroll = 10;
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
	    hand.add(c);
	}

	public void removeCard(int c){
	    // remove the card c from the player's hand
        hand.remove(hand.get(c));
    }

    public void bets(double amt){
        // player makes a bet
        this.bet = amt;
        bankroll = bankroll - bet;

    }

    public void winnings(double odds){ //odd is what we win
        //	adjust bankroll if player wins
    	bankroll = bankroll * odds;
    }

    public double getBankroll(){
        // return current balance of bankroll
        return bankroll;
    }

    public void organizeHand(){

    	Collections.sort(hand);    //this is how I sort from left to right by # value     

    }

    public void showHand(){

    	organizeHand();  //this is the implementation of sorting by value

    	for(int i = 0; i < hand.size(); i++){

    		System.out.print(hand.get(i));

    	}
    }

    public void showReplacementOptions(){

    	organizeHand();  //this is the implementation of sorting by value

    	for(int i = 0; i < hand.size(); i++){

    		System.out.println(hand.get(i) + " = " + i);

    	}

    }

    public void replace(int i){

    	this.replace = i;
    	hand.remove(hand.get(replace));

    }


    public void payout(){

    	if(payout == 250){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 250x your bet!");
    		bankroll = bankroll + 250;
    		System.out.println("Your bankroll is now" + bankroll); ///// do bet * bankroll 

    	} else if(payout == 50){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 50x your bet!");
    		bankroll = bankroll + (bet * 50);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 25){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 25x your bet!");
    		bankroll = bankroll + (bet * 25);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 6){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 6x your bet!");
    		bankroll = bankroll + (bet * 6);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 5){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 5x your bet!");
    		bankroll = bankroll + (bet * 5);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 4){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 4x your bet!");
    		bankroll = bankroll + (bet * 4);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 3){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 3x your bet!");
    		bankroll = bankroll + (bet * 3);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 2){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 2x your bet!");
    		bankroll = bankroll + (bet * 2);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else if(payout == 1){

    		System.out.println();
    		System.out.println("YOUR PAYOUT IS 1x your bet!");
    		bankroll = bankroll + (bet * 1);
    		System.out.println("Your bankroll is now " + bankroll);

    	} else {

    		System.out.println();
    		System.out.println("YOU WIN NOTHING - KEEP GAMBLING THOUGH...");
    		System.out.println("Your bankroll is now " + bankroll);

    	}




    }

    public void handValue(){

    	Card locMin = hand.get(0);  
    	int cardZeroMatch = 1;
    	int cardZeroRank = 1;

    	for(int i = 1; i < hand.size(); i++){

    		if(hand.get(i).getRank() == locMin.getRank()){

    			cardZeroMatch++;
    			cardZeroRank = locMin.getRank();

    		}

    	}

    	Card locMin1 = hand.get(1);  
    	int cardOneMatch = 1;
    	int cardOneRank = 1;

    	if(cardZeroMatch == 1){ //so if no match to *card one* was found

	    	for(int i = 2; i < hand.size(); i++){

	    		if(hand.get(i).getRank() == locMin1.getRank()){ 

	    			cardOneMatch++;
	    			cardOneRank = locMin1.getRank();

	    		}

	    	}

    	}

    	Card locMin2 = hand.get(2);  
    	int cardTwoMatch = 1;
    	int cardTwoRank = 1;

    	if(cardOneMatch == 1){ //so if no match to *card one OR card two* was found

	    	for(int i = 3; i < hand.size(); i++){

	    		if(hand.get(i).getRank() == locMin2.getRank()){

	    			cardTwoMatch++;
	    			cardTwoRank = locMin2.getRank();

	    		}

	    	}

    	}

    	Card locMin3 = hand.get(3);  
    	int cardThreeMatch = 1;
    	int cardThreeRank = 1;

    	if(cardTwoMatch == 1){ //so if no match to *card one OR card two OR three* was found

	    	for(int i = 4; i < hand.size(); i++){

	    		if(hand.get(i).getRank() == locMin3.getRank()){ 

	    			cardThreeMatch++;
	    			cardThreeRank = locMin3.getRank();

	    		}

	    	}

    	}
    	



    	int matchTwo = 1;
    	int matchTwoRank = 1;

    	int nextPosition = cardOneMatch; //because if match = 3 we start at pos 3
		Card locMin4 = hand.get(nextPosition);

		if(nextPosition == 1){ //this would be for no first pair

			for(int i = nextPosition + 1; i < hand.size(); i++){

    			if(hand.get(i).getRank() == locMin4.getRank()){

    			matchTwo++;
    			matchTwoRank = locMin4.getRank();

    			}

    		}

		}
    	
    	if(nextPosition == 2 || nextPosition == 3){

    		for(int i = nextPosition + 1; i < hand.size(); i++){

    			if(hand.get(i).getRank() == locMin2.getRank()){

    			matchTwo++;
    			matchTwoRank = locMin2.getRank();

    			}

    		}

    	} 
		

    	int straightCount = 1;

    	for(int i = 0; i < hand.size()-1; i++){

    		if(hand.get(i+1).getRank() == hand.get(i).getRank() + 1){

    			straightCount++;

    		}

    	}

    	int flushability = 1;

    	for(int i = 0; i < hand.size()-1; i++){

    		if(hand.get(i).getSuit() == hand.get(i+1).getSuit()){

    			flushability++;

    		}

    	}

    	if(hand.get(0).getRank() == 2 && hand.get(1).getRank() == 3 
            && hand.get(2).getRank() == 4 && hand.get(3).getRank() == 5 
            && hand.get(4).getRank() == 14)    {

    		straightCount = 5;	

    	}

    	int royalStraight = 0;

    	for(int i = 0; i < hand.size(); i++){

    		if(hand.get(i).getRank() == i+10){

    		royalStraight++;	

    		}

    	}



		if (royalStraight == 5 && flushability == 5) {

    	System.out.println();
    	System.out.println("THAT'S A ROYAL FLUSH");
    	payout = 250;

    	} else if (straightCount == 5 && flushability == 5) {

    	System.out.println();
    	System.out.println("THAT'S A SRAIGHT FLUSH");
    	payout = 50;

    	}

		else if (cardZeroMatch == 2 && cardTwoMatch == 3) {

		System.out.println();
    	System.out.println("THAT'S A FULL HOUSE");
    	payout = 6;

    	} else if (cardZeroMatch == 3 && cardThreeMatch == 2) {

    	System.out.println();
    	System.out.println("THAT'S A FULL HOUSE");
    	payout = 6;

    	} else if (flushability == 5) {

    	System.out.println();
    	System.out.println("THAT'S A FLUSH");
    	payout = 5;

    	} else if (straightCount == 5) {

    	System.out.println();
    	System.out.println("THAT'S A SRAIGHT");
    	payout = 4;

    	}

    	else if (cardZeroMatch == 4 || cardOneMatch == 4){

    	System.out.println();

    		if(cardZeroMatch == 4){

    			System.out.println("YOU'VE GOT 4  " + cardZeroRank + "s");

    		} else {

    			System.out.println("YOU'VE GOT 4  " + cardOneRank + "s");

    		}

    	System.out.println("THAT'S A FOUR OF A KIND");
		payout = 25;

    	} else if (cardZeroMatch == 3 || cardOneMatch == 3 || cardTwoMatch == 3){

    	System.out.println();


    		if(cardZeroMatch == 3){

    			System.out.println("YOU'VE GOT 3  " + cardZeroRank + "s");

    		} else if(cardOneMatch == 3){

    			System.out.println("YOU'VE GOT 3  " + cardOneRank + "s");

    		} else {

    			System.out.println("YOU'VE GOT 3  " + cardTwoRank + "s");

    		}

    	System.out.println("THAT'S A THREE OF A KIND");
    	payout = 3;

    	}

		else if (cardZeroMatch == 2 && cardTwoMatch == 2) {

		System.out.println();
		System.out.println("YOU'VE GOT 2  " + cardZeroRank 
            + "s and 2 " + cardTwoRank + "s");
    	System.out.println("THAT'S TWO PAIRS");
    	payout = 2;

    	} else if (cardZeroMatch == 2 && cardThreeMatch == 2) {

    	System.out.println();
    	System.out.println("YOU'VE GOT 2  " + cardZeroRank 
            + "s and 2 " + cardThreeRank + "s");
    	System.out.println("THAT'S TWO PAIRS");
    	payout = 2;

    	} else if (cardOneMatch == 2 && cardThreeMatch == 2) {

    	System.out.println();
    	System.out.println("YOU'VE GOT 2  " + cardOneRank 
            + "s and 2 " + cardThreeRank + "s");
    	System.out.println("THAT'S TWO PAIRS");
    	payout = 2;

    	} else if (cardZeroMatch == 2 || cardOneMatch == 2 
            || cardTwoMatch == 2 || cardThreeMatch == 2){
    	
    	System.out.println();

    	    if(cardZeroMatch == 2){

    			System.out.println("YOU'VE GOT 2  " + cardZeroRank + "s");

    		} else if(cardOneMatch == 2){

    			System.out.println("YOU'VE GOT 2  " + cardOneRank + "s");

    		} else if(cardTwoMatch == 2){

    			System.out.println("YOU'VE GOT 2  " + cardTwoRank + "s");

    		} else {

    			System.out.println("YOU'VE GOT 2  " + cardThreeRank + "s");

    		}

    	System.out.println("THAT'S A PAIR");
    	payout = 1;

    	} else {

    	System.out.println();
    	System.out.println("WELL NO PAIR WAS FOUND");
        payout = 0;

    	}


    }


        // you may wish to use more methods here
}