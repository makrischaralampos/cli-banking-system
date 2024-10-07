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
                        System.out.println("Account created successfully.");
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

                        if (depositAmount <= 0) {
                            System.out.println("Error: Deposit amount must be positive.");
                        } else {
                            accountToDeposit.deposit(depositAmount);
                            System.out.println("Deposit successful.");
                        }
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

                        if (withdrawalAmount <= 0) {
                            System.out.println("Error: Withdrawal amount must be positive.");
                        } else if (withdrawalAmount > accountToWithdraw.getBalance()) {
                            System.out.println("Error: Insufficient balance.");
                        } else {
                            accountToWithdraw.withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful.");
                        }
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
                    System.out.println("Thank you for using the CLI Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Clean up
        scanner.close();
    }
}