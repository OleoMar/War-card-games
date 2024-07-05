package game;

import java.util.ArrayList; // Import ArrayList from java.util

public class MultiplayerGame extends AbstractGame {

    // Constructor to create a new multiplayer game with two players
    public MultiplayerGame(String player1Name, String player2Name) {
        super(player1Name, player2Name);
    }

    // Override the play method to implement the game logic for multiplayer game
    @Override
    public void play() {
        dealCards(); // Deal cards to both players

        // Continue the game until one player has no cards left
        while (!isGameOver()) {
            printPlayerCardCount(); // Print the number of cards each player has

            Cards card1 = player1.playCard(); // Player 1 plays a card
            Cards card2 = player2.playCard(); // Player 2 plays a card

            System.out.println("Player 1 plays: " + card1.getName());
            System.out.println("Player 2 plays: " + card2.getName());

            // Determine the winner of the round
            if (card1.getVal() > card2.getVal()) {
                System.out.println("Player 1 wins the round!");
                player1.addCard(card1); // Add the played cards to player 1's deck
                player1.addCard(card2);
            } else if (card2.getVal() > card1.getVal()) {
                System.out.println("Player 2 wins the round!");
                player2.addCard(card1); // Add the played cards to player 2's deck
                player2.addCard(card2);
            } else {
                // War scenario: both players played cards of the same value
                System.out.println("War!");

                ArrayList<Cards> warCards = new ArrayList<>();
                warCards.add(card1);
                warCards.add(card2);

                boolean warEnded = false;
                // Continue the war until one player wins or both players run out of cards
                while (!warEnded &&!player1.getCards().isEmpty() &&!player2.getCards().isEmpty()) {
                    for (int i = 0; i < 3; i++) {
                        if (!player1.getCards().isEmpty()) {
                            warCards.add(player1.playCard()); // Player 1 plays three more cards
                        }
                        if (!player2.getCards().isEmpty()) {
                            warCards.add(player2.playCard()); // Player 2 plays three more cards
                        }
                    }

                    Cards warCard1 = warCards.get(warCards.size() - 3);
                    Cards warCard2 = warCards.get(warCards.size() - 2);
                    Cards warCard3 = warCards.get(warCards.size() - 1);

                    System.out.println("Player 1 draws: " + warCard1.getName());
                    System.out.println("Player 2 draws: " + warCard2.getName());

                    // Determine the winner of the war
                    if (warCard1.getVal() > warCard2.getVal()) {
                        System.out.println("Player 1 wins the war!");
                        warEnded = true;
                        player1.addCards(warCards); // Add all war cards to player 1's deck
                    } else if (warCard2.getVal() > warCard1.getVal()) {
                        System.out.println("Player 2 wins the war!");
                        warEnded = true;
                        player2.addCards(warCards); // Add all war cards to player 2's deck
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
        MultiplayerGame game = new MultiplayerGame("Player 1", "Player 2");
        game.play(); // Start the game
    }
}
