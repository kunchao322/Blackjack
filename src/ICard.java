/**
 * {@code Cards} interface represents the Cards
 * It has several methods getScore, getSuits, getName, setSuits, setName, setCard, swap, printCard
 */

interface ICard {

    /**
     * Get the Score of the Cards
     *
     * @return the Score
     */

    int getScore();

    /**
     * Get the Suits of the Cards
     *
     * @return the Suit
     */

    int getSuits();

    /**
     * Set the Suits of the Cards
     *
     * @throws IllegalArgumentException when Card is not set to the valid suit
     */

    void setSuits(int suits) throws IllegalArgumentException;

    /**
     * Get the name of the Cards
     *
     * @return the name
     */

    int getName();

    /**
     * Set the Name of the Cards
     *
     * @throws IllegalArgumentException when Card is not set to the valid name
     */

    void setName(int name) throws IllegalArgumentException;

    /**
     * Set the Card of the value of suits and name
     */

    void setCard(int suits, int name);

    /**
     * swap method to set Suits to the temporary suits values and set Name to the temporary name values
     */

    void swap(Card c1);

    /**
     * Print out the Card
     */

    void printCard();
}