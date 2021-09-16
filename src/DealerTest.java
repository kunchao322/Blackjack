import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Dealer class.
 * Considered both static and nonstatic methods.
 */


public class DealerTest {
    private Dealer dealer;
    private Card c1, c2, c3, c4;

    @Before
    public void setUp() {
        c1 = new Card(1, 1);
        c2 = new Card(2, 2);
        c3 = new Card(3, 7);
        c4 = new Card(4, 13);

        dealer = new Dealer();
    }

    @Test
    public void hit() {
        dealer.addCard(c1);
        dealer.addCard(c2);
        assertTrue(dealer.hit());

        dealer.addCard(c3);
        assertFalse(dealer.hit());
    }

    @Test
    public void hitBlackJack() {
        dealer.addCard(c1);
        dealer.addCard(c4);
        assertFalse(dealer.hit());
    }

}