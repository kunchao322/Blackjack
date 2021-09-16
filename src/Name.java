/**
 * enum Names with values ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING.
 * <p>
 * return switch case
 */

enum Names {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    /**
     * toString method to return the switch case
     *
     * @return switch case
     */

    @Override
    public String toString() {
        return switch (this) {
            case ACE -> "Ace";
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
        };
    }
}
