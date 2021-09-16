/**
 * {@code Dealer} subclass of BlackJack builds Dealer object
 * It has two methods printCardsHidden1, and hit
 */

public class Dealer extends BlackJack {

    /**
     * Default constructor to inherit the base default constructor
     */

    public Dealer() {
        super();
    }

    /**
     * Print out the Dealer's cards in hand with the first card hidden
     */

    public void printCardsHidden1() {
        if (this.getQty() == 0) {
            System.out.println("There is no card in dealer's hand.");
        }

        System.out.println("Dealer's cards in hand with 1st card hidden:");
        for (int i = 1; i < this.getQty(); i++) {
            System.out.println(this.getCard(i));
        }
    }


    /**
     * hit boolean Method return the countScore if score is less and equal to 17
     * Dealer will hit until the cards total 17 or higher.
     *
     * @return boolean of the countScore
     */

    public boolean hit() {
        return this.countScore() <= 17;
    }
}
