import java.util.Scanner;

/**
 * {@code Game} subclass of BlackJack builds Game object
 * It has eight methods printOptions, gameStarts, hittingCardsPlayer, hittingCardsDealer, printCardsOnTable, showCardsOnTable, getWinner, and main method
 */


public class Game extends BlackJack {

    private static Deck deck;
    private final BlackJack player;
    private final Dealer dealer;

    /**
     * Construct Game object with default empty constructor
     */


    public Game() {
        deck = new Deck();
        player = new BlackJack();
        dealer = new Dealer();
    }

    /**
     * printOptions Method to print out the options that player can enter
     *
     * @return the Scanner value
     */

    public int printOptions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter 1 to hit, other numbers to stand.");
        System.out.println("* Hit--ask for another card.");
        System.out.println("* Stand--hold your total and your turn is ended.");

        return keyboard.nextInt();
    }


    /**
     * gameStarts Method to Shuffle deck cards twice to start the game.
     */

    public void gameStarts() {
        deck.shuffle();
        deck.shuffle();
    }

    /**
     * hittingCardsPlayer Method to check if player burst
     */

    public void hittingCardsPlayer() {
        if (!player.burst()) {
            player.drawFromDeck(deck, 1);
        } else {
            System.out.println("Player burst!");
        }
    }

    /**
     * hittingCardsDealer Method to check if Dealer stop hit
     */

    public void hittingCardsDealer() {
        if (dealer.hit()) {
            dealer.drawFromDeck(deck, 1);
        } else {
            System.out.println("Dealer stops hitting!");
        }
    }

    /**
     * printCardsOnTable Method to print out the cards that are on table for both Dealer's card and Player's cards
     */

    public void printCardsOnTable() {
        System.out.println("\n-----------Dealer's cards:-----------");
        dealer.printCardsHidden1();

        System.out.println("\n+++++++++++Player's cards:+++++++++++");
        player.printCards();

    }

    /**
     * showCardsOnTable Method to print out the Dealer's scores and the Player's score
     */

    public void showCardsOnTable() {
        System.out.println("\n-----------Dealer's cards:-----------");
        dealer.printSortedCards();
        System.out.println("Dealer's score:" + dealer.countScore());

        System.out.println("\n+++++++++++Player's cards:+++++++++++");
        player.printSortedCards();
        System.out.println("Player's score:" + player.countScore());
    }

    /**
     * getWinner Method to print out the winner or it is a tie
     */

    public void getWinner() {
        if ((!dealer.burst()) && (dealer.countScore() > player.countScore() || player.burst())) {
            System.out.println("*************Dealer wins.*************");
            showCardsOnTable();
        } else if (!player.burst() && (player.countScore() > dealer.countScore() || dealer.burst())) {
            System.out.println("*************Player wins.*************");
            showCardsOnTable();
        } else {
            System.out.println("*************It's a tie.*************");
            showCardsOnTable();
        }
    }


    /**
     * main method that print out the whole game and get the Winner
     */

    public static void main(String[] args) {

        Game game = new Game();

        System.out.println("Game Starts...");
        game.gameStarts();
        int decision;


        game.player.drawFromDeck(deck, 1);
        game.dealer.drawFromDeck(deck, 1);
        game.player.drawFromDeck(deck, 1);
        game.dealer.drawFromDeck(deck, 1);
        game.printCardsOnTable();

        if (game.player.blackJack())
            System.out.println("\nPlayer Black Jack!");

        else {

            decision = game.printOptions();

            while (decision == 1) {
                game.hittingCardsPlayer();
                if (game.player.burst())
                    break;
                // game.hittingCardsDealer();
                game.printCardsOnTable();

                decision = game.printOptions();
            }
        }

        while (game.dealer.hit()) {
            game.hittingCardsDealer();
        }

        game.getWinner();
    }
}
