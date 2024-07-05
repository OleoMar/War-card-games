package game;
import java.util.ArrayList; // Import ArrayList from java.util

public class SinglePlayerGame extends AbstractGame {

    // The Joker player
    private Player joker;

    // Constructor to create a new single-player game with a given player name
    public SinglePlayerGame(String playerName) {
        super(playerName, "Joker"); // Initialize the game with the player and Joker
        this.joker = new Player("Joker"); // Create a new Joker player
    }

    // Override the play method to implement the game logic for single-player game
    @Override
    public void play() {
        dealCards(); // Deal cards to both the player and the Joker

        // Continue the game until one player has no cards left
        while (!isGameOver()) {
            printPlayerCardCount(); // Print the number of cards each player has

            Cards playerCard = player1.playCard(); // Player plays a card
            Cards jokerCard = joker.playCard(); // Joker plays a card

            System.out.println(player1.getName() + " plays: " + playerCard.getName());
            System.out.println("Joker plays: " + jokerCard.getName());

            // Determine the winner of the round
            if (playerCard.getVal() > jokerCard.getVal()) {
                System.out.println(player1.getName() + " wins the round!");
                player1.addCard(playerCard); // Add the played cards to the player's deck
                player1.addCard(jokerCard);
            } else if (jokerCard.getVal() > playerCard.getVal()) {
                System.out.println("Joker wins the round!");
                joker.addCard(playerCard); // Add the played cards to the Joker's deck
                joker.addCard(jokerCard);
            } else {
                // War scenario: both players played cards of the same value
                System.out.println("War!");

                ArrayList<Cards> warCards = new ArrayList<>();
                warCards.add(playerCard);
                warCards.add(jokerCard);

                boolean warEnded = false;
                // Continue the war until one player wins or both players run out of cards
                while (!warEnded && !player1.getCards().isEmpty() && !joker.getCards().isEmpty()) {
                    for (int i = 0; i < 3; i++) {
                        if (!player1.getCards().isEmpty()) {
                            warCards.add(player1.playCard()); // Player plays three more cards
                        }
                        if (!joker.getCards().isEmpty()) {
                            warCards.add(joker.playCard()); // Joker plays three more cards
                        }
                    }

                    Cards warCard1 = warCards.get(warCards.size() - 3);
                    Cards warCard2 = warCards.get(warCards.size() - 2);
                    Cards warCard3 = warCards.get(warCards.size() - 1);

                    System.out.println(player1.getName() + " draws: " + warCard1.getName());
                    System.out.println("Joker draws: " + warCard2.getName());

                    // Determine the winner of the war
                    if (warCard1.getVal() > warCard2.getVal()) {
                        System.out.println(player1.getName() + " wins the war!");
                        warEnded = true;
                        player1.addCards(warCards); // Add all war cards to the player's deck
                    } else if (warCard2.getVal() > warCard1.getVal()) {
                        System.out.println("Joker wins the war!");
                        warEnded = true;
                        joker.addCards(warCards); // Add all war cards to the Joker's deck
                    } else {
                        System.out.println("War continues...");
                    }
                }
            }
        }

        declareWinner(); // Declare the winner of the game
    }

    // Main method to test the game
    public static void main(String[] args) {
        SinglePlayerGame game = new SinglePlayerGame("Player 1");
        game.play(); // Start the game
    }
}
