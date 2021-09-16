/**
 * {@code BlackJack} subclass of Hand builds BlackJack object
 * It has five methods hasAce, blackJack, countScoreHelper, countScore, burst
 */

public class BlackJack extends Hand {

    /**
     * Default constructor to inherit the base default constructor
     */

    public BlackJack() {
        super();
    }

    /**
     * hasAce boolean Method to return true when Ace is equal to 1
     *
     * @return ture when Card name is equal to 1
     */

    public boolean hasAce() {
        for (int i = 0; i < this.getQty(); i++)
            if (this.getCard(i).getName() == 1)
                return true;
        return false;
    }

    /**
     * blackJack boolean Method return the Card name
     *
     * @return boolean of name of the Card
     */


    public boolean blackJack() {
        if (this.getQty() == 2 && hasAce())
            return this.getCard(0).getName() >= 10 || this.getCard(1).getName() >= 10;
        return false;
    }


    /**
     * countScoreHelper Method return the sum of the Card
     *
     * @return the sum of the Card
     */
    public int countScoreHelper() {
        int sum = 0;
        for (int i = 0; i < this.getQty(); i++) {
            sum += this.getCard(i).getScore();
        }
        return sum;
    }

    /**
     * countScore Method return sum of the Card
     *
     * @return the sum of the Card
     */

    public int countScore() {
        if (this.hasAce()) {
            int sum = this.countScoreHelper();
            int sum11 = sum + 10;

            if (sum11 <= 21) return sum11;
            else return sum;

        } else {
            return countScoreHelper();
        }
    }

    /**
     * burst boolean Method return the countScore greater than 21
     *
     * @return boolean of the countScore
     */

    public boolean burst() {
        return countScore() > 21;
    }

}
