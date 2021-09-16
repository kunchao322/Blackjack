import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the BlackJack class.
 * Considered both static and nonstatic methods.
 */

public class BlackJackTest {
    private BlackJack cards;
    private Card c1, c2, c3, c4;

    @Before
    public void setUp() {
        c1 = new Card(1, 1);
        c2 = new Card(2, 2);
        c3 = new Card(3, 10);
        c4 = new Card(4, 13);

        cards = new BlackJack();
        cards.addCard(c1);
        cards.addCard(c2);
        cards.addCard(c3);
        cards.addCard(c4);
    }

    @Test
    public void hasAce() {
        assertTrue(cards.hasAce());
    }

    @Test
    public void blackJackFalse() {
        BlackJack cardsTemp = new BlackJack();
        cardsTemp.addCard(c1);
        cardsTemp.addCard(c2);
        assertFalse(cardsTemp.blackJack());
    }

    @Test
    public void blackJackTrue() {
        BlackJack cardsTemp1 = new BlackJack();
        cardsTemp1.addCard(c1);
        cardsTemp1.addCard(c4);
        assertTrue(cardsTemp1.blackJack());
    }

    @Test
    public void countScoreAce1Burst() {
        assertEquals(23, cards.countScore());
    }

    @Test
    public void countScoreAce1() {
        BlackJack cardsTemp2 = new BlackJack();
        cardsTemp2.addCard(c1);
        cardsTemp2.addCard(c2);
        cardsTemp2.addCard(c3);
        assertEquals(13, cardsTemp2.countScore());
    }

    @Test
    public void countScoreAce11BlackJack() {
        BlackJack cardsTemp2 = new BlackJack();
        cardsTemp2.addCard(c1);
        cardsTemp2.addCard(c4);

        assertEquals(21, cardsTemp2.countScore());
    }

    @Test
    public void countScoreAce11() {
        //Ace, 2, 8 = 21
        BlackJack cardsTemp2 = new BlackJack();
        cardsTemp2.addCard(c1);
        cardsTemp2.addCard(new Card(1, 2));
        cardsTemp2.addCard(new Card(1, 8));

        assertEquals(21, cardsTemp2.countScore());
    }

    @Test
    public void countScoreAce11Case2() {
        //Ace, 2, 3 = 16
        BlackJack cardsTemp2 = new BlackJack();
        cardsTemp2.addCard(c1);
        cardsTemp2.addCard(new Card(1, 2));
        cardsTemp2.addCard(new Card(1, 3));

        assertEquals(16, cardsTemp2.countScore());
    }

    @Test
    public void burst() {
        assertTrue(cards.burst());
    }
}
