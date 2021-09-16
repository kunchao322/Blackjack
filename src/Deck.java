import java.util.*;

/**
 * {@code Deck} subclass of Card builds Deck object stores an ArrayList of Card objects
 * It has nine methods getQty, printCards, getCard, shuffle, addCard, sort, printSortedCards, remove, and main method
 */

public class Deck extends Card {
    private ArrayList<Card> deck;

    /**
     * Construct Card object with default constructor represent the standard 52 cards
     */

    public Deck() {

        deck = new ArrayList<>(52);
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                this.deck.add(new Card(i, j));
            }
        }
    }

    /**
     * Constructor: A constructor that takes the parameter qty
     *
     * @param qty to limited the name and suit that randomly generated
     */

    public Deck(int qty) {
        Random rand = new Random();
        deck = new ArrayList<>(this.getQty());
        for (int i = 0; i < qty; i++) {
            int randName = rand.nextInt(13) + 1;
            int randSuit = rand.nextInt(4) + 1;
            this.deck.add(new Card(randSuit, randName));
        }
    }

    /**
     * getQty Method return the size of the deck
     *
     * @return the size of the deck
     */

    public int getQty() {
        if (deck == null)
            return 0;
        return deck.size();
    }

    /**
     * printCards Method that print out the Cards
     */

    public void printCards() {
        if (deck.size() == 0) {
            System.out.println("There is no card.");
        }
        for (Card value : deck)
            value.printCard();
    }

    /**
     * getCard Method return the get deck
     *
     * @param ndx to get ndx
     * @return get deck
     */

    public Card getCard(int ndx) {
        return deck.get(ndx);
    }

    /**
     * shuffle Method that shuffle the cards in the deck.
     * By randomly swapping every card in the deck.
     */

    public void shuffle() {
        Random random = new Random();
        int randTarget;

        for (Card value : deck) {
            randTarget = random.nextInt(52);
            value.swap(deck.get(randTarget));
        }
    }

    /**
     * addCard Method Add a new card to the deck.
     *
     * @param c take a Card object c as a parameter and add it to the ArrayList.
     */

    public void addCard(Card c) {
        deck.add(c);
    }

    /**
     * sort Method Sort the cards in the deck ordered by name.
     */

    public void sort() {
        Collections.sort(deck);
    }

    /**
     * printSortedCards Method that print out the sorted Cards
     *
     * @param deck take a Deck object deck sort and print out the cards
     */

    public static void printSortedCards(Deck deck) {
        deck.sort();
        deck.printCards();
    }

    /**
     * printSortedCards Method that print out the sorted Cards
     */

    public void printSortedCards() {
        if (this.getQty() == 0)
            System.out.println("There is nor card in the deck.");
        this.sort();
        this.printCards();
    }

    /**
     * remove Method Remove a card from the deck.
     *
     * @return removes the first card stored in the ArrayList and returns it.
     */

    public Card remove() {
        Card removed;
        removed = deck.get(0);
        deck.remove(deck.get(0));
        return removed;
    }


    /**
     * main method that add, sort and print out the Card
     */

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printCards();
        deck.addCard(new Card(1, 1));
        System.out.println(deck.getQty());

        deck.sort();
        System.out.println(deck.getQty());

        deck.printCards();
        System.out.println(deck.getQty());

    }

}

