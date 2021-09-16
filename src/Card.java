/**
 * {@code Card} class stores the suit(Clubs, Diamonds, Hearts,Spades) and name(Ace, 2, 10, Jack) of each card.
 * Along with appropriate accessors, constructors, and mutators.
 * This Card stores an integer suits which is the suit of the Card.
 * This Card stores an integer name which is the name of the card.
 * This Card stores a method swap to set Suits to the temporary suits values and set Name to the temporary name values
 * This Card stores a method printCard to Print out the Card
 * This Card stores a boolean method equals to compare with Object o
 * This Card stores a method compareTo to compare with Card o
 */


public class Card implements Comparable<Card>, ICard {

    private int suits;
    private int name;

    /**
     * Construct Card object with default empty constructor
     */

    public Card() {
    }

    /**
     * Constructs a Card object with two arguments suit and name
     *
     * @param suit the suit of the Card
     * @param name the name of the Card
     *             catch Exception when Card are not set to the correct values
     */

    public Card(int suit, int name) {
        try {
            setSuits(suit);
            setName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Please reset your cards' values.");
        }
    }


    /**
     * ToString method
     *
     * @return the String of suits and the String of names
     */

    @Override
    public String toString() {
        int suit = this.getSuits();
        Suits suitsString = null;
        int name = this.getName();
        Names namesString = null;

        switch (suit) {
            case 1 -> suitsString = Suits.CLUBS;
            case 2 -> suitsString = Suits.DIAMONDS;
            case 3 -> suitsString = Suits.HEARTS;
            case 4 -> suitsString = Suits.SPADES;
        }

        switch (name) {
            case 1 -> namesString = Names.ACE;
            case 2 -> namesString = Names.TWO;
            case 3 -> namesString = Names.THREE;
            case 4 -> namesString = Names.FOUR;
            case 5 -> namesString = Names.FIVE;
            case 6 -> namesString = Names.SIX;
            case 7 -> namesString = Names.SEVEN;
            case 8 -> namesString = Names.EIGHT;
            case 9 -> namesString = Names.NINE;
            case 10 -> namesString = Names.TEN;
            case 11 -> namesString = Names.JACK;
            case 12 -> namesString = Names.QUEEN;
            case 13 -> namesString = Names.KING;
        }

        return suitsString + " " + namesString;

    }

    /**
     * Get the Score of the Cards
     *
     * @return the Score
     */

    public int getScore() {
        return Math.min(this.getName(), 10);
    }

    /**
     * Get the Suits of the Cards
     *
     * @return the Suit
     */

    public int getSuits() {
        return this.suits;
    }

    /**
     * Set the Suits of the Cards
     *
     * @throws IllegalArgumentException when Card is not set to the valid suit
     */

    public void setSuits(int suits) throws IllegalArgumentException {
        if (suits < 0 || suits > 4) {
            throw new IllegalArgumentException("Suit has to be 1, 2, 3, 4.");
        }
        this.suits = suits;
    }

    /**
     * Get the name of the Cards
     *
     * @return the name
     */

    public int getName() {
        return this.name;
    }

    /**
     * Set the Name of the Cards
     *
     * @throws IllegalArgumentException when Card is not set to the valid name
     */

    public void setName(int name) throws IllegalArgumentException {
        if (name < 0 || name > 13) {
            throw new IllegalArgumentException("Name has to be integer from 1-13.");
        }
        this.name = name;
    }

    /**
     * Set the Card of the value of suits and name
     */

    public void setCard(int suits, int name) {
        this.setName(name);
        this.setSuits(suits);
    }

    /**
     * swap method to set Suits to the temporary suits values and set Name to the temporary name values
     */

    public void swap(Card c1) {
        int suitsTemp, nameTemp;
        suitsTemp = this.suits;
        nameTemp = this.name;

        this.setName(c1.getName());
        this.setSuits(c1.getSuits());

        c1.setSuits(suitsTemp);
        c1.setName(nameTemp);

    }

    /**
     * Print out the Card
     */


    @Override
    public void printCard() {
        System.out.println(this);
    }


    /**
     * Equals method that overrides Object’s equals method
     *
     * @return true two Cards are equal and false two cards are not equal
     */


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Card))
            return false;

        Card otherO = (Card) o;
        return this.getName() == otherO.getName() &&
                this.getSuits() == otherO.getSuits();
    }

    /**
     * compareTo method compare this card with Card o by names
     *
     * @return the compared result
     */

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getName(), o.getName());
    }

    /**
     * main method that print out Card c
     */

    public static void main(String[] args) {
        Card c = new Card(1, 1);
        System.out.println(c);
    }
}
