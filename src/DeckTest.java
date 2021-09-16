import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Deck class.
 * Considered both static and nonstatic methods.
 */


public class DeckTest {

    private Deck deck, deck1, deck2;

    @org.junit.Before
    public void setUp() throws Exception {
        deck = new Deck();
        deck1 = new Deck(0);
        deck2 = new Deck(2);
    }

//    @org.junit.Test
//    public void printDeck() {
//        deck.printCards();
//    }

//    @org.junit.Test
//    public void printDeck1() {
//        deck1.printCards();
//    }

//    @org.junit.Test
//    public void printDeck2() {
//        deck2.printCards();
//    }

    @org.junit.Test
    public void shuffle() {
        deck.printCards();
        deck.shuffle();
        System.out.println("After shuffle...");
        deck.printCards();
    }

    @Test
    public void addCard() {
        Card c1 = new Card(1, 2);

        deck.addCard(c1);
        assertEquals(53, deck.getQty());
        //empty deck;
        deck1.addCard(c1);
        assertEquals(1, deck1.getQty());
    }

    @Test
    public void getQty() {
        assertEquals(52, deck.getQty());
        assertEquals(0, deck1.getQty());
        assertEquals(2, deck2.getQty());
    }

    @Test
    public void remove() {
        assertEquals(deck.getCard(0), deck.remove());
    }

    @Test
    public void getCard() {
        assertEquals("Clubs Ace", deck.getCard(0).toString());
    }

    @Test
    public void sort() {
        deck1.addCard(new Card(1, 1));
        deck1.addCard(new Card(2, 3));
        deck1.addCard(new Card(3, 2));
        deck1.addCard(new Card(4, 13));

        deck1.sort();

        for (int i = 0; i < deck1.getQty() - 1; i++) {
            assertEquals(-1, deck1.getCard(i).compareTo(deck1.getCard(i + 1)));
        }
    }
}