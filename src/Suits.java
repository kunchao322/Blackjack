/**
 * enum Names with values CLUBS, DIAMONDS, HEARTS, SPADES
 * <p>
 * return switch case
 */


enum Suits {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    /**
     * toString method to return the switch case
     *
     * @return switch case
     */

    @Override
    public String toString() {

        return switch (this) {
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";

        };
    }
}