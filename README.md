# Simple CLI Banking System

## Overview

This is a command-line interface (CLI) banking system built in Java. It allows users to create accounts,
deposit and withdraw money, and check their account balances.
The system uses in-memory storage (ArrayList) to manage accounts.

## Features

- 📝 Create new accounts
- 💵 Deposit money into an account
- 💸 Withdraw money from an account (with validation or balance)
- 🧾 Check account balances
- 🚪 Exit the application

## How to Run

### Prerequisites

- **Java** installed on your system (version 8 or later)
- A command-line terminal (e.g., Command Prompt, Terminal, etc.)

### Steps to Run the Application

1. **Clone the repository**:

```bash
git clone https://github.com/makrischaralampos/cli-banking-system.git
cd cli-banking-system
```

2. **Compile the Java program**: Open a terminal in the project directory and run:

```bash
javac Main.java
```

3. **Run the program**:

```bash
java Main
```

### Commands Overview

Once you run the application, you will be greeted with a main menu that offers the following options:

```bash
===========================================
  Welcome to the CLI Banking System  
===========================================

----------------------
 What would you like to do?
----------------------
1. 📝 Create a new account
2. 💵 Deposit money
3. 💸 Withdraw money
4. 🧾 Check account balance
5. 🚪 Exit
Please enter a number (1-5):
```

Here's what each option does:

1. **📝 Create a new account**

You will be prompted to enter an account number, the account holder's name, and the initial balance.
The system ensures that account numbers are unique.

2. **💵 Deposit money**

You will be asked for the account number and the amount you wish to deposit.
The amount is added to the account's balance.

3. **💸 Withdraw money**

You will be asked for the account number and the amount you wish to withdraw. If the balance is sufficient,
the withdrawal will be successful. Otherwise, you will receive an error message.

4. **🧾 Check account balance**

Enter the account number, and the system will display the current balance of that account.

5. **🚪 Exit**

This command exits the application.

## Error Handling

The system includes error handling for various edge cases:

- Invalid input (e.g., non-numeric input for amounts)
- Attempting to withdraw more than the available balance
- Duplicate account numbers during account creation

## Example Usage

```bash
===========================================
  Welcome to the CLI Banking System  
===========================================
1. 📝 Create a new account
2. 💵 Deposit money
3. 💸 Withdraw money
4. 🧾 Check account balance
5. 🚪 Exit
Please enter a number (1-5): 1

Enter account number: 101
Enter account holder name: Alice
Enter initial balance: 500
✅ Account created successfully!

Please enter a number (1-5): 2

Enter account number: 101
Enter amount to deposit: 200
✅ Deposit successful! New balance: 700

Please enter a number (1-5): 4

Enter account number: 101
💵 Current balance: 700
```

## License

This project is open-source and free to use under the MIT License.