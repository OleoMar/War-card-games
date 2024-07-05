
Edit
Copy code
package game;

public class Cards {
    private String name;
    private String suit;
    private int val;

    public Cards(String value, String suit) {
        this.name = value + " of " + suit; // set card name
        this.suit = suit; // set suit
        switch (value) {
            case "2":
                this.val = 2; // set value for 2
                break;
            case "3":
                this.val = 3; // set value for 3
                break;
            case "4":
                this.val = 4; // set value for 4
                break;
            case "5":
                this.val = 5; // set value for 5
                break;
            case "6":
                this.val = 6; // set value for 6
                break;
            case "7":
                this.val = 7; // set value for 7
                break;
            case "8":
                this.val = 8; // set value for 8
                break;
            case "9":
                this.val = 9; // set value for 9
                break;
            case "10":
                this.val = 10; // set value for 10
                break;
            case "Jack":
                this.val = 11; // set value for Jack
                break;
            case "Queen":
                this.val = 12; // set value for Queen
                break;
            case "King":
                this.val = 13; // set value for King
                break;
            case "Ace":
                this.val = 14; // set value for Ace
                break;
        }
    }

    public String getName() {
        return name; // return card name
    }

    public int getVal() {
        return val; // return card value
    }
}
