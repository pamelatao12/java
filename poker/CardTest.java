package poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import poker.Card.Suit;

class CardTest {

	@Test
	void testGetSuit() {
		Card a = new Card(1, Suit.SPADES);
		assertEquals(Suit.SPADES, a.getSuit());

		Card b = new Card(1, Suit.HEARTS);
		assertEquals(Suit.HEARTS, b.getSuit());

		Card c = new Card(1, Suit.DIAMONDS);
		assertEquals(Suit.DIAMONDS, c.getSuit());

		Card d = new Card(1, Suit.CLUBS);
		assertEquals(Suit.CLUBS, d.getSuit());
	}

	@Test
	void testGetValue() {
		Card a = new Card(1, Suit.SPADES);
		assertEquals(1, a.getValue());
		
		Card b = new Card(2, Suit.SPADES);
		assertEquals(2, b.getValue());
		
		Card c = new Card(3, Suit.SPADES);
		assertEquals(3, c.getValue());
		
		Card d = new Card(4, Suit.SPADES);
		assertEquals(4, d.getValue());
		
		Card e = new Card(5, Suit.SPADES);
		assertEquals(5, e.getValue());
		
		Card f = new Card(6, Suit.SPADES);
		assertEquals(6, f.getValue());
		
		Card g = new Card(7, Suit.SPADES);
		assertEquals(7, g.getValue());
		
		Card h = new Card(8, Suit.SPADES);
		assertEquals(8, h.getValue());
		
		Card i = new Card(9, Suit.SPADES);
		assertEquals(9, i.getValue());
		
		Card j = new Card(10, Suit.SPADES);
		assertEquals(10, j.getValue());
		
		Card k = new Card(11, Suit.SPADES);
		assertEquals(11, k.getValue());
		
		Card l = new Card(12, Suit.SPADES);
		assertEquals(12, l.getValue());
		
		Card m = new Card(13, Suit.SPADES);
		assertEquals(13, m.getValue());
	}

	@Test
	void testToString() {
		Card a = new Card(1, Suit.SPADES);
		assertEquals("Ace of Spades", a.toString());
		
		Card b = new Card(11, Suit.HEARTS);
		assertEquals("Jack of Hearts", b.toString());
		
		Card c = new Card(12, Suit.DIAMONDS);
		assertEquals("Queen of Diamonds", c.toString());
		
		Card d = new Card(13, Suit.CLUBS);
		assertEquals("King of Clubs", d.toString());
		
		Card e = new Card(8, Suit.HEARTS);
		assertEquals("8 of Hearts", e.toString());
	}

}
