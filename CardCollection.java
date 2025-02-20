import java.util.*;

class Card {
    String suit;
    String rank;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardCollection {

    static List<Card> deck = new ArrayList<>();

    public static void addCard(String suit, String rank) {
        deck.add(new Card(suit, rank));
    }

    public static List<Card> findCardsBySuit(String suit) {
        List<Card> result = new ArrayList<>();
        for (Card card : deck) {
            if (card.suit.equalsIgnoreCase(suit)) {
                result.add(card);
            }
        }
        return result;
    }

    public static void displayDeck() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty!");
        } else {
            System.out.println("Deck of Cards:");
            for (Card card : deck) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Add some example cards
        addCard("Hearts", "Ace");
        addCard("Hearts", "2");
        addCard("Spades", "King");
        addCard("Clubs", "Jack");
        addCard("Diamonds", "Queen");

        do {
            System.out.println("\nCard Management System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Suit (Hearts/Spades/Clubs/Diamonds): ");
                    String suit = scanner.nextLine();
                    System.out.print("Enter Rank (Ace/2/3/4/.../King/Queen/Jack): ");
                    String rank = scanner.nextLine();
                    addCard(suit, rank);
                    break;

                case 2:
                    System.out.print("Enter Suit to find: ");
                    String searchSuit = scanner.nextLine();
                    List<Card> cards = findCardsBySuit(searchSuit);
                    if (cards.isEmpty()) {
                        System.out.println("No cards found for suit " + searchSuit);
                    } else {
                        System.out.println("Cards with suit " + searchSuit + ":");
                        for (Card card : cards) {
                            System.out.println(card);
                        }
                    }
                    break;

                case 3:
                    displayDeck();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
