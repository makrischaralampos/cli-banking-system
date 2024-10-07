import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static AccountService accountService = new AccountService();

    private static final int CREATE_ACCOUNT = 1;
    private static final int DEPOSIT_MONEY = 2;
    private static final int WITHDRAW_MONEY = 3;
    private static final int CHECK_BALANCE = 4;
    private static final int EXIT = 5;

    // Entry point of the program
    public static void main(String[] args) {
        boolean running = true;

        // Welcome message
        System.out.println("===========================================");
        System.out.println("  Welcome to the CLI Banking System  ");
        System.out.println("===========================================");

        // Main loop
        while (running) {
            showMenu();

            try {
                // Read the user's choice
                int choice = scanner.nextInt();
                System.out.println(); // Line break for spacing
                handleUserChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("⚠\uFE0F  Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Clean up
        scanner.close();
    }

    private static void showMenu() {
        // Displaying the menu
        System.out.println("\n----------------------");
        System.out.println(" What would you like to do?");
        System.out.println("----------------------");
        System.out.println("1. \uD83D\uDCDD Create a new account");
        System.out.println("2. \uD83D\uDCB5 Deposit money");
        System.out.println("3. \uD83D\uDCB8 Withdraw money");
        System.out.println("4. \uD83E\uDDFE Check account balance");
        System.out.println("5. \uD83D\uDEAA Exit");
        System.out.print("\nPlease enter a number (1-5): ");
    }

    // Handle the user's choice
    private static void handleUserChoice(int choice) {
        switch (choice) {
            case CREATE_ACCOUNT:
                accountService.createAccount();
                break;
            case DEPOSIT_MONEY:
                accountService.deposit();
                break;
            case WITHDRAW_MONEY:
                accountService.withdraw();
                break;
            case CHECK_BALANCE:
                accountService.checkBalance();
                break;
            case EXIT:
                // Exit
                System.out.println("\uD83D\uDC4B Thank you for using the CLI Banking System! Have a great day! \uD83D\uDE0A");
                System.exit(0);
                break;
            default:
                System.out.println("⚠\uFE0F  Invalid option! Please enter a number between 1 and 5.");
        }
    }
}