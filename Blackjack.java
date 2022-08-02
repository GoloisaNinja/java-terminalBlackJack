import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);
    public static int userHandTotal = 0;
    public static int computerHandTotal = 0;

    public static int drawRandomCard(String handToUpdate) {
        int card = new Random().nextInt(13) + 1;
        int cardValue = card;
        if (card > 10) {
            cardValue = 10;
        }
        if (handToUpdate.equals("user")) {
            userHandTotal += cardValue;
        } else {
            computerHandTotal += cardValue;
        }
        return card;
    }

    public static String faceDown() {
        return
                "   _____\n"+
                "  |     |\n"+
                "  |  J  |\n"+
                "  | JJJ |\n"+
                "  |  J  |\n"+
                "  |_____|\n";
    }

    public static String cardString(int card) {
        switch (card) {
            case 1:
                return "   _____\n" +
                       "  |A _  |\n" +
                       "  | ( ) |\n" +
                       "  |(_'_)|\n" +
                       "  |  |  |\n" +
                       "  |____V|\n";
            case 2:
                return "   _____\n" +
                       "  |2    |\n" +
                       "  |  o  |\n" +
                       "  |     |\n" +
                       "  |  o  |\n" +
                       "  |____Z|\n";
            case 3:
                return "   _____\n" +
                       "  |3    |\n" +
                       "  | o o |\n" +
                       "  |     |\n" +
                       "  |  o  |\n" +
                       "  |____E|\n";
            case 4:
                return "   _____\n" +
                       "  |4    |\n" +
                       "  | o o |\n" +
                       "  |     |\n" +
                       "  | o o |\n" +
                       "  |____h|\n";
            case 5:
                return "   _____ \n" +
                       "  |5    |\n" +
                       "  | o o |\n" +
                       "  |  o  |\n" +
                       "  | o o |\n" +
                       "  |____S|\n";
            case 6:
                return "   _____ \n" +
                       "  |6    |\n" +
                       "  | o o |\n" +
                       "  | o o |\n" +
                       "  | o o |\n" +
                       "  |____6|\n";
            case 7:
                return "   _____ \n" +
                       "  |7    |\n" +
                       "  | o o |\n" +
                       "  |o o o|\n" +
                       "  | o o |\n" +
                       "  |____7|\n";
            case 8:
                return "   _____ \n" +
                       "  |8    |\n" +
                       "  |o o o|\n" +
                       "  | o o |\n" +
                       "  |o o o|\n" +
                       "  |____8|\n";
            case 9:
                return "   _____ \n" +
                       "  |9    |\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |____9|\n";
            case 10:
                return "   _____ \n" +
                       "  |10  o|\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |o o o|\n" +
                       "  |___10|\n";
            case 11:
                return "   _____\n" +
                       "  |J  ww|\n" +
                       "  | o {)|\n" +
                       "  |o o% |\n" +
                       "  | | % |\n" +
                       "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                       "  |Q  ww|\n" +
                       "  | o {(|\n" +
                       "  |o o%%|\n" +
                       "  | |%%%|\n" +
                       "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                       "  |K  WW|\n" +
                       "  | o {)|\n" +
                       "  |o o%%|\n" +
                       "  | |%%%|\n" +
                       "  |_%%%>|\n";
            default:
                return "something went wrong...";
        }
    }

    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String selection = scan.nextLine();
        if (selection.equals("hit") || selection.equals("stay")) {
            return selection;
        } else {
            System.out.println("Invalid option - you need to type 'hit' or 'stay' please...");
            return hitOrStay();
        }
    }

    public static void declareWinner() {
        if (userHandTotal > computerHandTotal) {
            System.out.println("\n****You win!****");
            System.out.println("Your hand value: " + userHandTotal);
            System.out.println("Dealer hand value: " + computerHandTotal);
        } else if (computerHandTotal > userHandTotal) {
            System.out.println("\n****Dealer wins! :( ****");
            System.out.println("Your hand value: " + userHandTotal);
            System.out.println("Dealer hand value: " + computerHandTotal);
        } else {
            System.out.println("\n****House wins in a tie! :( ****");
            System.out.println("Your hand value: " + userHandTotal);
            System.out.println("Dealer hand value: " + computerHandTotal);
        }
    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();

        String userFirstCard = cardString(drawRandomCard("user"));
        String userSecondCard = cardString(drawRandomCard("user"));
        String compFirstCard = cardString(drawRandomCard("comp"));
        String compSecondCard = cardString(drawRandomCard("comp"));

        System.out.println("\n You got a \n" + userFirstCard + "\n and a \n" + userSecondCard);
        System.out.println("your total is: " + userHandTotal);
        System.out.println("\n The dealer shows \n" + compFirstCard +"\n and has " +
                               "a card facing down \n" + faceDown());
        System.out.println("\n The dealer's total is hidden");

        while(true) {
            if (userHandTotal > 21) {
                System.out.println("Player busts! Hand total: " + userHandTotal);
                System.out.println("Dealer wins :( ");
                System.exit(0);
            }
            String instruction = hitOrStay();
            if (instruction.equals("stay")) {
                break;
            } else {
                System.out.println("\nYou get a \n " + cardString(drawRandomCard("user")));
                System.out.println("\nYour new total is: " + userHandTotal);
            }

        }
        System.out.println("\nDealer's Turn");
        System.out.println("\nDealer has: \n" + compFirstCard + "\n and a \n" + compSecondCard);
        System.out.println("Dealer total is: " + computerHandTotal);

        while(computerHandTotal < 17) {
            System.out.println("Dealer hits...");
            System.out.println("\nDealer gets a \n" + cardString(drawRandomCard("comp")));
            System.out.println("\nDealer total is now: " + computerHandTotal);
            if (computerHandTotal > 21) {
                System.out.println("Dealer busts with total of: " + computerHandTotal);
                System.out.println("You win!");
                System.exit(0);
            }
        }

        declareWinner();
        scan.close();

    }

}

