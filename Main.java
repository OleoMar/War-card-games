package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner to read user input

        try {
            System.out.println("Welcome to War Card Game!"); // Display game welcome message
            System.out.println("Choose an option:");
            System.out.println("1. Multiplayer (Player 1 vs Player 2)");
            System.out.println("2. Single Player (Player 1 vs Joker)");

            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    startMultiplayerGame(); // Start multiplayer game
                    break;
                case 2:
                    startSinglePlayerGame(); // Start single player game
                    break;
                default:
                    System.out.println("Invalid choice. Exiting..."); // Handle invalid choice
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: Please enter a valid integer choice."); // Handle invalid input
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Handle general exceptions
        } finally {
            scanner.close(); // Close the scanner
        }
    }

    private static void startMultiplayerGame() {
        MultiplayerGame game = new MultiplayerGame("Player 1", "Player 2"); // Create a new multiplayer game
        game.play(); // Start the game
    }

    private static void startSinglePlayerGame() {
        SinglePlayerGame game = new SinglePlayerGame("Player 1"); // Create a new single player game
        game.play(); // Start the game
    }
}
