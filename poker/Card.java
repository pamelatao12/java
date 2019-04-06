package poker;

public class Card {
	private int value; // number from 1 to 13
	private Suit suit; // suit of card

	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	enum Suit {
		SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds"), CLUBS("Clubs");

		private String name;

		Suit(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		String valueString;
		switch (value) {

		case 1:
			valueString = "Ace";
			break;
		case 11:
			valueString = "Jack";
			break;
		case 12:
			valueString = "Queen";
			break;
		case 13:
			valueString = "King";
			break;
		default:
			valueString = value + "";
			break;
		}
		return valueString + " of " + suit.toString();
	}

	public static void main(String[] args) {
		Card first = new Card(1, Suit.CLUBS);
		System.out.println(first.toString());
	}
}
