import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Cards> cards;
    private int numberOfCards;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Cards>();
        this.numberOfCards = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
        this.numberOfCards = cards.size();
    }

    public void addCard(Cards card) {
        this.cards.add(card);
        this.numberOfCards++;
    }

    public void removeCard(Cards card) {
        this.cards.remove(card);
        this.numberOfCards--;
    }
}
