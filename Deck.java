package game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Cards> cards;

    public Deck() {
        this.cards = new ArrayList<Cards>(); // create a new deck
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; // define suits
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // define values
        for (String suit : suits) {
            for (String value : values) {
                this.cards.add(new Cards(value, suit)); // add card to deck
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards); // shuffle deck
    }

    public ArrayList<Cards> deal(int numCards) {
        ArrayList<Cards> dealtCards = new ArrayList<Cards>(); // create list for dealt cards
        for (int i = 0; i < numCards; i++) {
            dealtCards.add(this.cards.remove(0)); // deal card from top of deck
        }
        return dealtCards;
    }
}
