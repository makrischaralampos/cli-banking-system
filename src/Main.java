import java.util.Scanner;

public class Main {

    // Entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null; // Initially no account created
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
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    account = new Account(accountNumber, accountHolderName, initialBalance);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    // Deposit Money
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 3:
                    // Withdraw Money
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    // Check balance
                    if (account != null) {
                        System.out.println("Account balance: " + account.getBalance());
                    } else {
                        System.out.println("No account found. Please create an account first.");
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