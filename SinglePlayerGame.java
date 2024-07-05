package game;

import java.util.ArrayList;

public class SinglePlayerGame extends AbstractGame {

    // The Joker player
    private Player joker;

    // Constructor to create a new single-player game with a given player name
    public SinglePlayerGame(String playerName, String player2Name) {
        super(playerName, player2Name); // Initialize the game with the player and Joker
        this.joker = this.player2; // Assign player2 as Joker
    }

    // Override the play method to implement the game logic for single-player game
    @Override
    public void play() {
        dealCards(); // Deal cards to both players

        // Continue the game until one player has no cards left
        while (!isGameOver()) {
            printPlayerCardCount(); // Print the number of cards each player has

            Cards card1 = player1.playCard(); // Player 1 plays a card
            Cards card2 = joker.playCard(); // Joker plays a card

            System.out.println("Player 1 plays: " + card1.getName());
            System.out.println("Joker plays: " + card2.getName());

            // Determine the winner of the round
            if (card1.getVal() > card2.getVal()) {
                System.out.println("Player 1 wins the round!");
                player1.addCard(card1); // Add the played cards to player 1's deck
                player1.addCard(card2);
            } else if (card2.getVal() > card1.getVal()) {
                System.out.println("Joker wins the round!");
                joker.addCard(card1); // Add the played cards to Joker's deck
                joker.addCard(card2);
            } else {
                // War scenario: both players played cards of the same value
                System.out.println("War!");

                ArrayList<Cards> warCards = new ArrayList<>();
                warCards.add(card1);
                warCards.add(card2);

                boolean warEnded = false;
                // Continue the war until one player wins or both players run out of cards
                while (!warEnded && !player1.getCards().isEmpty() && !joker.getCards().isEmpty()) {
                    for (int i = 0; i < 3; i++) {
                        if (!player1.getCards().isEmpty()) {
                            warCards.add(player1.playCard()); // Player 1 plays three more cards
                        }
                        if (!joker.getCards().isEmpty()) {
                            warCards.add(joker.playCard()); // Joker plays three more cards
                        }
                    }

                    Cards warCard1 = warCards.get(warCards.size() - 3);
                    Cards warCard2 = warCards.get(warCards.size() - 2);

                    System.out.println("Player 1 draws: " + warCard1.getName());
                    System.out.println("Joker draws: " + warCard2.getName());

                    // Determine the winner of the war
                    if (warCard1.getVal() > warCard2.getVal()) {
                        System.out.println("Player 1 wins the war!");
                        warEnded = true;
                        player1.addCards(warCards); // Add all war cards to player 1's deck
                    } else if (warCard2.getVal() > warCard1.getVal()) {
                        System.out.println("Joker wins the war!");
                        warEnded = true;
                        joker.addCards(warCards); // Add all war cards to Joker's deck
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
        SinglePlayerGame game = new SinglePlayerGame("Player 1", "Joker");
        game.play(); // Start the game
    }
}
