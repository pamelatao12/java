package poker;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> deck; //arraylist containing Card objects, null if empty
	
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public List<Card> addCard(Card card) {
		if (!deck.contains(card)) {
			deck.add(card);
		}
		return deck;
	}

	public List<Card> removeCard(Card card) {
		if (!deck.contains(card)) {
			deck.remove(card);
		}
		return deck;
	}
}
