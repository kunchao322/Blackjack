import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Card class.
 * Considered both static and nonstatic methods.
 */

public class CardTest {
    private Card c1, c2, c3, c4;

    @Before
    public void setUp() throws Exception {
        c1 = new Card(1, 1);
        c2 = new Card(2, 2);
        c3 = new Card(3, 10);
        c4 = new Card(4, 13);
    }

    @Test
    public void testToString() {
        assertEquals("Clubs Ace", c1.toString());
        assertEquals("Diamonds 2", c2.toString());
        assertEquals("Hearts 10", c3.toString());
        assertEquals("Spades King", c4.toString());
    }

    @Test
    public void getSuits() {
        assertEquals(1, c1.getSuits());
        assertEquals(2, c2.getSuits());
        assertEquals(3, c3.getSuits());
        assertEquals(4, c4.getSuits());
    }

    @Test
    public void setSuits() {
        c1.setSuits(4);
        assertEquals(4, c1.getSuits());

        c4.setSuits(1);
        assertEquals(1, c4.getSuits());

    }

    @Test(expected = IllegalArgumentException.class)
    public void setSuitsIllegal() {
        c1.setSuits(5);
    }

    @Test
    public void getName() {
        assertEquals(1, c1.getName());
        assertEquals(2, c2.getName());
        assertEquals(10, c3.getName());
        assertEquals(13, c4.getName());
    }

    @Test
    public void setName() {
        c1.setName(10);
        assertEquals(10, c1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameIllegal() {
        c1.setName(15);
    }

    @Test
    public void setCard() {
        c1.setCard(2, 2);
        //    assertTrue(c1.equals(c2));
        assertEquals(2, c1.getName());
        assertEquals(2, c1.getSuits());
    }

    @Test
    public void swap() {
        c1.swap(c2);
        assertEquals("Clubs Ace", c2.toString());
        assertEquals("Diamonds 2", c1.toString());

        c3.swap(c4);
        assertEquals("Hearts 10", c4.toString());
        assertEquals("Spades King", c3.toString());
    }

    @Test
    public void testEquals() {
        Card card1 = new Card(1, 1);
        assertEquals(card1, c1);
    }

    @Test
    public void compareTo() {
        assertEquals(-1, c1.compareTo(c2));
        assertEquals(1, c4.compareTo(c3));

        c1.setName(2);
        assertEquals(0, c1.compareTo(c2));
    }


}
