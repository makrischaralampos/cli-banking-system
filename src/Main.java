import java.util.Scanner;

public class Main {

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
                    System.out.println("Create Account chosen");
                    // Add logic for account creation
                    break;
                case 2:
                    System.out.println("Deposit Money chosen");
                    // Add logic for depositing money
                    break;
                case 3:
                    System.out.println("Withdraw Money chosen");
                    // Add logic for withdrawing money
                    break;
                case 4:
                    System.out.println("Check Balance chosen");
                    // Add logic for checking balance
                    break;
                case 5:
                    System.out.println("Exiting...");
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