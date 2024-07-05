package game;

import java.util.ArrayList;

public abstract class AbstractGame {
    protected Player player1;
    protected Player player2;
    protected Deck deck;

    public AbstractGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name); // create player 1
        this.player2 = new Player(player2Name); // create player 2
        this.deck = new Deck(); // create deck
    }

    public abstract void play(); // abstract method to play the game

    protected void dealCards() {
        this.deck.shuffle(); // shuffle deck
        ArrayList<Cards> allCards = this.deck.deal(52); // deal 52 cards
        ArrayList<Cards> player1Cards = new ArrayList<>(allCards.subList(0, 26)); // player 1's cards
        ArrayList<Cards> player2Cards = new ArrayList<>(allCards.subList(26, 52)); // player 2's cards
        this.player1.addCards(player1Cards); // add cards to player 1
        this.player2.addCards(player2Cards); // add cards to player 2
    }

    protected void printPlayerCardCount() {
        System.out.println("Player 1 has " + player1.getCards().size() + " cards."); // print player 1's card count
        System.out.println("Player 2 has " + player2.getCards().size() + " cards."); // print player 2's card count
        System.out.println(); // empty line
    }

    protected boolean isGameOver() {
        return player1.getCards().isEmpty() || player2.getCards().isEmpty(); // check if game is over
    }

    protected void declareWinner() {
        if (player1.getCards().size() > player2.getCards().size()) {
            System.out.println("Player 1 wins the game!"); // player 1 wins
        } else if (player2.getCards().size() > player1.getCards().size()) {
            System.out.println("Player 2 wins the game!"); // player 2 wins
        } else {
            System.out.println("It's a tie!"); // tie game
        }
    }
}
