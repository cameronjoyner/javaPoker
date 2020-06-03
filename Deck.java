//Cameron Joyner
//CGJ2115
//DECK CREATED, SHUFFLED AND DEALT

import java.util.List;
import java.util.Collections;
import java.util.Arrays;


public class Deck {
	
	private Card[] cards = new Card[52];
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		top = 0;
		//Card[] cards = new Card[52];	
			
    		for(int i = 0, j = 1; i < 13; i++, j++){ //i represents the suits
        
        		cards[i] = new Card(1,j); //hearts
		        cards[i+13] = new Card(2,j); //diamond
		        cards[i+26] = new Card(3,j); //club
		        cards[i+39] = new Card(4,j); //spade

    		}

		top = 0;
	}
	
	public void shuffle(){
		// shuffle the deck here

		List<Card> cardList = Arrays.asList(cards);

		Collections.shuffle(cardList);

		cardList.toArray(cards);

	}
	
	public Card deal(){
		//System.out.println("dealing!");
		return cards[top++];
		// deal the top card in the deck
	}

	
	// add more methods here if needed

}