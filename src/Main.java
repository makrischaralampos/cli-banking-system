import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Welcome to the CLI Banking System");

        // Main loop
        while (running) {
            // Displaying the menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Handle the user's choice
            switch (choice) {
                // Create Account
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    if (findAccount(accountNumber) != null) {
                        System.out.println("Account number already exists. Please choose a different account number.");
                    } else {
                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();

                        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
                        accounts.add(newAccount);
                        System.out.println("Account created successfully for " + accountHolderName);
                    }
                    break;

                case 2:
                    // Deposit Money
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    Account accountToDeposit = findAccount(accountNumber);
                    if (accountToDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        accountToDeposit.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Withdraw Money
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    Account accountToWithdraw = findAccount(accountNumber);
                    if (accountToWithdraw != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        accountToWithdraw.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Check balance
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    Account accountToCheck = findAccount(accountNumber);
                    if (accountToCheck != null) {
                        System.out.println("Account balance: " + accountToCheck.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // Exit
                    running = false; // Stop the loop to exit
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Clean up
        scanner.close();
        System.out.println("Thank you for using the CLI Banking System!");
    }
}