import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Hand class.
 * Considered both static and nonstatic methods.
 */

public class HandTest {
    private Deck deck;
    private Hand hand;

    @Before
    public void setUp() {
        deck = new Deck();
        hand = new Hand();
    }

    @Test
    public void drawFromDeckStatic() {
        Hand.drawFromDeck(deck, hand, 5);
        assertEquals(5, hand.getQty());
        assertEquals(47, deck.getQty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawFromDeckIllegalStatic() {
        Hand.drawFromDeck(deck, hand, 55);
    }

    @Test
    public void returnToDeckStatic() {
        hand.addCard(new Card(1, 1));
        hand.addCard(new Card(1, 2));
        assertEquals(2, hand.getQty());

        Hand.returnToDeck(deck, hand, 2);
        assertEquals(0, hand.getQty());
        assertEquals(54, deck.getQty());
    }

    @Test
    public void drawFromDeckNonStatic() {
        hand.drawFromDeck(deck, 12);
        assertEquals(12, hand.getQty());
        assertEquals(40, deck.getQty());
    }

    @Test
    public void returnToDeckNonStatic() {
        hand.addCard(new Card(1, 1));
        hand.addCard(new Card(2, 2));

        hand.returnToDeck(deck, 2);
        assertEquals(0, hand.getQty());
        assertEquals(54, deck.getQty());
    }
}
