package game;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    // Constructor to initialize the game with two players
    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.deck = new Deck();
        this.deck.shuffle();

        // Deal cards to players
        ArrayList<Cards> allCards = this.deck.deal(52);
        ArrayList<Cards> player1Cards = new ArrayList<>(allCards.subList(0, 26));
        ArrayList<Cards> player2Cards = new ArrayList<>(allCards.subList(26, 52));
        this.player1.addCards(player1Cards);
        this.player2.addCards(player2Cards);
    }

    // Method to play the game
    public void play() {
        while (this.player1.hasCards() && this.player2.hasCards()) {
            Cards card1 = this.player1.playCard();
            Cards card2 = this.player2.playCard();

            System.out.println("Player 1 plays: " + card1.getName());
            System.out.println("Player 2 plays: " + card2.getName());

            if (card1.getVal() > card2.getVal()) {
                System.out.println("Player 1 wins the round!");
                this.player1.addCard(card1);
                this.player1.addCard(card2);
            } else if (card2.getVal() > card1.getVal()) {
                System.out.println("Player 2 wins the round!");
                this.player2.addCard(card1);
                this.player2.addCard(card2);
            } else {
                // War scenario
                System.out.println("War!");

                ArrayList<Cards> warCards = new ArrayList<>();
                warCards.add(card1);
                warCards.add(card2);

                boolean warEnded = false;
                while (!warEnded && this.player1.hasCards() && this.player2.hasCards()) {
                    for (int i = 0; i < 3; i++) {
                        if (this.player1.hasCards()) {
                            warCards.add(this.player1.playCard());
                        }
                        if (this.player2.hasCards()) {
                            warCards.add(this.player2.playCard());
                        }
                    }

                    Cards warCard1 = warCards.get(warCards.size() - 3);
                    Cards warCard2 = warCards.get(warCards.size() - 2);
                    Cards warCard3 = warCards.get(warCards.size() - 1);

                    System.out.println("Player 1 draws: " + warCard1.getName());
                    System.out.println("Player 2 draws: " + warCard2.getName());

                    if (warCard1.getVal() > warCard2.getVal()) {
                        System.out.println("Player 1 wins the war!");
                        warEnded = true;
                        this.player1.addCards(warCards);
                    } else if (warCard2.getVal() > warCard1.getVal()) {
                        System.out.println("Player 2 wins the war!");
                        warEnded = true;
                        this.player2.addCards(warCards);
                    } else {
                        System.out.println("War continues...");
                    }
                }
            }
        }

        // Determine the winner
        if (this.player1.getCards().size() > this.player2.getCards().size()) {
            System.out.println("Player 1 wins the game!");
        } else if (this.player2.getCards().size() > this.player1.getCards().size()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        Game game = new Game("Player 1", "Player 2");
        game.play();
    }
}
