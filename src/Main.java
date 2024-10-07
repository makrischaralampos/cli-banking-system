import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    // List to store all accounts
    private static List<Account> accounts = new ArrayList<>();

    // Method to find an account by account number
    private static Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Welcome message
        System.out.println("Welcome to the CLI Banking System!");

        // Main loop
        while (running) {
            // Displaying the menu
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check account balance");
            System.out.println("5. Exit");

            try {
                System.out.println("Please enter a number (1-5): ");
                // Read the user's choice
                int choice = scanner.nextInt();

                // Handle the user's choice
                switch (choice) {
                    case 1:
                        // Create Account
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.next();

                        // Check if the account number already exists
                        if (findAccount(accountNumber) != null) {
                            System.out.println("Error: Account number already exists.");
                        } else {
                            System.out.print("Enter account holder name: ");
                            String accountHolderName = scanner.next();

                            // Validate that the name is not empty
                            if (accountHolderName.trim().isEmpty()) {
                                System.out.println("Error: Account holder name cannot be empty");
                                break;
                            }

                            System.out.print("Enter initial balance: ");
                            double initialBalance = scanner.nextDouble();

                            // Validate that the initial balance is not negative
                            if (initialBalance < 0) {
                                System.out.println("Error: Initial balance cannot be negative.");
                                break;
                            }

                            // Create and add new account
                            Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
                            accounts.add(newAccount);
                            System.out.println("Account created successfully!");
                        }
                        break;

                    case 2:
                        // Deposit Money
                        System.out.print("Please enter your account number: ");
                        accountNumber = scanner.next();
                        Account accountToDeposit = findAccount(accountNumber);
                        if (accountToDeposit != null) {
                            System.out.print("Enter the amount to deposit: ");
                            double depositAmount = scanner.nextDouble();

                            if (depositAmount > 0) {
                                accountToDeposit.deposit(depositAmount);
                            } else {
                                System.out.println("Oops! The deposit amount must be positive. Please try again.");
                            }
                        } else {
                            System.out.println("Sorry, we couldn't find an account with that number.");
                        }
                        break;

                    case 3:
                        // Withdraw Money
                        System.out.print("Please enter your account number: ");
                        accountNumber = scanner.next();
                        Account accountToWithdraw = findAccount(accountNumber);
                        if (accountToWithdraw != null) {
                            System.out.print("Enter the amount to withdraw: ");
                            double withdrawalAmount = scanner.nextDouble();

                            if (withdrawalAmount > 0) {
                                accountToWithdraw.withdraw(withdrawalAmount);
                            } else {
                                System.out.println("Oops! The withdrawal amount must be positive. Please try again.");
                            }
                        } else {
                            System.out.println("Sorry, we couldn't find an account with that number.");
                        }
                        break;

                    case 4:
                        // Check balance
                        System.out.print("Please enter your account number: ");
                        accountNumber = scanner.next();
                        Account accountToCheck = findAccount(accountNumber);
                        if (accountToCheck != null) {
                            System.out.println("Your current balance is: $" + accountToCheck.getBalance());
                        } else {
                            System.out.println("Sorry, we couldn't find an account with that number.");
                        }
                        break;

                    case 5:
                        // Exit
                        System.out.println("Thank you for using the CLI Banking System! Have a great day!");
                        running = false; // Stop the loop to exit
                        break;

                    default:
                        System.out.println("Invalid option! Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Clean up
        scanner.close();
    }
}