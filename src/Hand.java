/**
 * {@code Hand} subclass of Deck builds Hand object represents the cards in a hand
 * Interacting cards in hand and in deck
 * It has six methods drawFromDeck, returnToDeck, drawFromDeck, returnToDeck, printSortedCards, and main method.
 */

public class Hand extends Deck {

    /**
     * Default constructor to inherit the base default constructor and set the hand to an empty set of cards.
     */

    public Hand() {
        super(0);
    }

    /**
     * drawFromDeck method with two parameters deck and qty
     *
     * @param deck take a Deck object deck as a parameter and getQty of deck
     * @param qty  to limited the Cards quantity
     * @throws IllegalArgumentException when the Cards quantity is more than qty in deck
     */

    public void drawFromDeck(Deck deck, int qty) throws IllegalArgumentException {
        if (qty < 0 || qty > deck.getQty()) {
            throw new IllegalArgumentException("Cards quantity should no more than qty in deck!");
        }

        for (int i = 0; i < qty; i++) {
            this.addCard(deck.remove());
        }
    }

    /**
     * returnToDeck Method to check the Cards quantity in hand
     *
     * @param deck take a Deck object deck as a parameter and getQty of deck
     * @param qty  to limited the Cards quantity
     * @throws IllegalArgumentException when the Cards quantity is more than qty in hand
     */

    public void returnToDeck(Deck deck, int qty) throws IllegalArgumentException {
        if (qty < 0 || qty > this.getQty()) {
            throw new IllegalArgumentException("Cards quantity should no more than qty in hand!");
        }
        for (int i = 0; i < qty; i++) {
            deck.addCard(this.remove());
        }
    }

    /**
     * drawFromDeck method with three parameters deck, hand, and qty
     *
     * @param deck take a Deck object deck as a parameter and getQty of deck
     * @param hand take a Hand object hand as a parameter
     * @param qty  to limited the Cards quantity
     * @throws IllegalArgumentException when the Cards quantity is more than qty in deck
     */

    public static void drawFromDeck(Deck deck, Hand hand, int qty) throws IllegalArgumentException {
        if (qty < 0 || qty > deck.getQty()) {
            throw new IllegalArgumentException("Cards quantity should no more than qty in deck!");
        }
        for (int i = 0; i < qty; i++) {
            hand.addCard(deck.remove());
        }
    }

    /**
     * returnToDeck Method to check the Cards quantity in hand
     *
     * @param deck take a Deck object deck as a parameter and getQty of deck
     * @param hand take a Hand object hand as a parameter
     * @param qty  to limited the Cards quantity
     * @throws IllegalArgumentException when the Cards quantity is more than qty in hand
     */

    public static void returnToDeck(Deck deck, Hand hand, int qty) throws IllegalArgumentException {
        if (qty < 0 || qty > hand.getQty()) {
            throw new IllegalArgumentException("Cards quantity should no more than qty in hand!");
        }
        for (int i = 0; i < qty; i++) {
            deck.addCard(hand.remove());
        }
    }

    /**
     * printSortedCards Method that print out the sorted Cards if the hand is not null
     *
     * @param hand take a Hand object hand as a parameter
     * @throws NullPointerException when the hand is null
     */

    public static void printSortedCards(Hand hand) throws NullPointerException {
        if (hand == null) {
            throw new NullPointerException("Hand is null.");
        }
        hand.sort();
        hand.printCards();
    }

    /**
     * main method that creates a deck of cards, shuffles the deck, and creates two hands of 5 cards each.
     * Cards removed from the deck and added to the hand.
     */

    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        deck.shuffle();

        System.out.println("Deck cards to hands:");

        drawFromDeck(deck, hand1, 5);
        drawFromDeck(deck, hand2, 5);

        System.out.println("\nCards in hand 1:");
        printSortedCards(hand1);
        System.out.println("\nCards in hand 2:");
        printSortedCards(hand2);
        System.out.println("\nCards in Deck:");
        printSortedCards(deck);

        System.out.println("Hand 1: " + hand1.getQty() + " Hand 2: " + hand2.getQty() + " Deck: " + deck.getQty());


        System.out.println("\n*************Returning hand cards to deck:*************");

        returnToDeck(deck, hand1, 5);
        returnToDeck(deck, hand2, 5);

        System.out.println("\nCards in hand 1:");
        hand1.printCards();
        System.out.println("\nCards in hand 2:");
        hand2.printCards();
        System.out.println("\nCards in Deck:");
        deck.printCards();

        System.out.println("Hand 1: " + hand1.getQty() + " Hand 2: " + hand2.getQty() + " Deck: " + deck.getQty());

    }

}
