import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountService {

    // List to store all accounts
    private List<Account> accounts = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
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
            }

            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();

            // Validate that the initial balance is not negative
            if (initialBalance < 0) {
                System.out.println("Error: Initial balance cannot be negative.");
            }

            // Create and add new account
            Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
            accounts.add(newAccount);
            System.out.println("Account created successfully!");
        }
    }

    public void deposit() {
        // Deposit Money
        System.out.print("Please enter your account number: ");
        String accountNumber = scanner.next();
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
    }

    public void withdraw() {
        // Withdraw Money
        System.out.print("Please enter your account number: ");
        String accountNumber = scanner.next();
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
    }

    public void checkBalance() {
        // Check balance
        System.out.print("Please enter your account number: ");
        String accountNumber = scanner.next();
        Account accountToCheck = findAccount(accountNumber);
        if (accountToCheck != null) {
            System.out.println("Your current balance is: $" + accountToCheck.getBalance());
        } else {
            System.out.println("Sorry, we couldn't find an account with that number.");
        }
    }

    // Method to find an account by account number
    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}