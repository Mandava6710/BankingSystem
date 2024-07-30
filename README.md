Name:Ganesh Mandava
ID:CT4JP5004
Domain:Java Programming
Durantion:July 15 to August 15 2024
Mentor: Muzammil Ahmed
Description:
Your Java code represents a basic online banking system with functionality for managing accounts, processing transactions, and viewing account details. Here's a detailed description of each component:

### **1.Account Class:**

The `Account` class models a bank account and includes various attributes and methods related to account operations.

- **Attributes:**
  - `accountHolder`: Name of the person who holds the account.
  - `accountNumber`: Unique identifier for the account.
  - `balance`: Current balance of the account.
  - `transactionHistory`: List of transaction strings that record all operations performed on the account.

- **Constructor:**
  - `Account(String accountNumber, String accountHolder)`: Initializes an account with a given number and holder name. Sets the initial balance to 0.0 and initializes the transaction history list.

- **Methods:**
  - `getAccountNumber()`: Returns the account number.
  - `getAccountHolder()`: Returns the account holder's name.
  - `getBalance()`: Returns the current balance of the account.
  - `deposit(double amount)`: Adds a specified amount to the account balance and records the deposit in the transaction history.
  - `withdraw(double amount)`: Subtracts a specified amount from the balance if sufficient funds are available, and records the withdrawal in the transaction history. Returns `true` if successful, `false` otherwise.
  - `transfer(Account beneficiary, double amount)`: Transfers a specified amount from this account to another account (beneficiary). Updates both accounts' balances and transaction histories. Returns `true` if successful, `false` otherwise.
  - `viewTransactionHistory()`: Prints out the transaction history of the account.
  - `display()`: Prints out the account holder's name, account number, and current balance.

### **2. BankingSystem Class:**

The `BankingSystem` class manages multiple `Account` instances and provides functionality for creating and accessing accounts.

- **Attributes:**
  - `accounts`: A `HashMap` that maps account numbers to their corresponding `Account` objects.

- **Methods:**
  - `createAccount(String accountHolder)`: Creates a new account with a unique account number based on the current size of the `accounts` map and a base number. Prints the account number upon successful creation.
  - `getAccount(String accountNumber)`: Retrieves the `Account` object associated with the given account number.
  - `displayAccounts()`: Lists all available accounts with the account holder names and numbers.

### **3. OnlineBanking Class:**

The `OnlineBanking` class contains the `main` method, which is the entry point of the application. It handles user interaction and performs banking operations based on user input.

- **Main Loop:**
  - Displays a menu with options for creating accounts, depositing, withdrawing, transferring money, viewing transaction history, managing personal information, and exiting the system.
  - Uses a `Scanner` object to read user input and executes corresponding operations based on the selected option.
  - Provides error handling for invalid inputs and informs users if accounts are not found or if transactions are unsuccessful.

### **Functional Flow:**

1. **Account Creation:**
   - User selects option 1 to create a new account by providing the account holder's name. A unique account number is generated, and the account is added to the system.

2. **Deposit Money:**
   - User selects option 2 to deposit money into an account by providing the account number and deposit amount.

3. **Withdraw Money:**
   - User selects option 3 to withdraw money from an account by providing the account number and withdrawal amount.

4. **Transfer Money:**
   - User selects option 4 to transfer money from one account to another. The system requires both sender and beneficiary account numbers and the transfer amount.

5. **View Transaction History:**
   - User selects option 5 to view the transaction history of an account by providing the account number.

6. **Manage Personal Information:**
   - User selects option 6 to view personal account details (account holder name, account number, balance) by providing the account number.

7. **Exit:**
   - User selects option 7 to exit the application.

### **Conclusion:**

The Java code provided implements a basic online banking system with essential functionalities for account management and transactions. Here’s a summary of its design, features, and potential areas for enhancement:

### **Design Summary:**

1. **Class Structure:**
   - **`Account` Class:** Represents individual bank accounts. Manages attributes like account holder's name, account number, balance, and transaction history. Includes methods for depositing, withdrawing, transferring funds, viewing transaction history, and displaying account details.
   - **`BankingSystem` Class:** Manages multiple `Account` instances. Provides functionalities for creating accounts, retrieving account details by account number, and listing all accounts.
   - **`OnlineBanking` Class:** Contains the `main` method for user interaction. Implements a console-based menu for account operations including creating accounts, depositing, withdrawing, transferring money, viewing transaction histories, and managing personal information.

2. **Functionality:**
   - **Account Creation:** Generates a unique account number and initializes a new account.
   - **Deposit/Withdraw:** Allows users to add or remove funds from an account, with appropriate checks for insufficient balance.
   - **Transfer:** Facilitates fund transfers between accounts, ensuring proper validation and updating transaction histories.
   - **Transaction History:** Provides a record of all transactions made on an account.
   - **Account Details:** Displays detailed information about a specific account.

### **Key Features:**

1. **Basic Operations:** Supports fundamental banking operations such as deposits, withdrawals, and transfers.
2. **Transaction Tracking:** Maintains a history of transactions for each account.
3. **Account Management:** Allows for account creation and retrieval of account details.
4. **User Interface:** Provides a simple text-based interface for interacting with the system.

