package game;

import java.util.ArrayList;

public class Player {
    private String name; // Player's name
    private ArrayList<Cards> cards; // Player's deck of cards

    // Constructor to create a new player with a given name
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>(); // Initialize the player's deck
    }

    // Getter for the player's name
    public String getName() {
        return name;
    }

    // Getter for the player's deck of cards
    public ArrayList<Cards> getCards() {
        return cards;
    }

    // Add a single card to the player's deck
    public void addCard(Cards card) {
        this.cards.add(card);
    }

    // Add multiple cards to the player's deck
    public void addCards(ArrayList<Cards> cards) {
        this.cards.addAll(cards);
    }

    // Play the top card from the player's deck
    public Cards playCard() {
        return this.cards.remove(0);
    }

    // Check if the player has any cards left in their deck
    public boolean hasCards() {
        return!this.cards.isEmpty();
    }
}
