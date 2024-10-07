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
        System.out.println("Welcome to the CLI Banking System!");

        // Main loop
        while (running) {
            showMenu();

            try {
                // Read the user's choice
                int choice = scanner.nextInt();
                handleUserChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Clean up
        scanner.close();
    }

    private static void showMenu() {
        // Displaying the menu
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Check account balance");
        System.out.println("5. Exit");
        System.out.print("Please enter a number (1-5): ");
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
                System.out.println("Thank you for using the CLI Banking System! Have a great day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option! Please enter a number between 1 and 5.");
        }
    }
}