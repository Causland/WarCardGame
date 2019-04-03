
public class Card {
	char suit;
	int number;	


	Card(char s, int n){
		suit = s;
		number = n;
	}

	public int getNumber() {
		return number;
	}
	
	public String getStringNumber() {
		if(number == 11){
			return "JACK";
		}
		else if(number == 12) {
			return "QUEEN";
		}
		else if(number == 13) {
			return "KING";
		}
		else if(number == 14) {
			return "ACE";
		}
		else {
			return String.valueOf(number);
		}
	}
	
	public String getShortName() {
		if(number == 11){
			return ("J" + suit);
		}
		else if(number == 12) {
			return ("Q" + suit);
		}
		else if(number == 13) {
			return ("K" + suit);
		}
		else if(number == 14) {
			return ("A" + suit);
		}
		else {
			return (String.valueOf(number) + suit);
		}
	}
	
	public String getSuit() {
		switch(this.suit) {
		case 'H':
			return "Hearts";
		case 'D':
			return "Diamonds";
		case 'C':
			return "Clubs";
		case 'S':
			return "Spades";
		default:
			return "NO SUIT";
		}
	}

		
	public String toString() {
		return this.getStringNumber() + " of " + this.getSuit();
	}
	

}