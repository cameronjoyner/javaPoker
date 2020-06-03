//Cameron Joyner
//CGJ2115
//CARD OBJECT CREATED

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		this.suit = s;
		this.rank = r;

	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted

		int compareValue = 0;

		if (c.rank > this.rank) {
			compareValue = -1;
		} else if (c.rank < this.rank) {
			compareValue = 1;
		} else {
			compareValue = 0;
		}
		return compareValue;
		

	}

	
	public String toString(){
		// use this method to easily print a Card object
		String suitTitle;
		String rankTitle;

		if(suit == 1){
			suitTitle = ("h");
		} else if(suit == 2){
			suitTitle = "d";
		} else if(suit == 3){
			suitTitle = "c";
		} else {
			suitTitle = "s";
		}

		if(rank == 2 ){
			
			rankTitle = "2";

		} else if(rank == 3 ){
			
			rankTitle = "3";

		} else if(rank == 4 ){
			
			rankTitle = "4";

		} else if(rank == 5 ){
			
			rankTitle = "5";

		} else if(rank == 6 ){
			
			rankTitle = "6";

		} else if(rank == 7 ){
			
			rankTitle = "7";

		} else if(rank == 8 ){
			
			rankTitle = "8";

		} else if(rank == 9 ){
			
			rankTitle = "9";

		} else if(rank == 10 ){
			
			rankTitle = "10";

		} else if(rank == 11) {

			rankTitle = "11";

		} else if(rank == 12) {

			rankTitle = "12";

		} else if(rank == 13){

			rankTitle = "13";

		} else {

			rankTitle = "14";
		}

		return suitTitle + rankTitle + " | "; 

	}

	public int getSuit(){
		return this.suit;
	}

	public int getRank(){
		return this.rank;
	}

}
