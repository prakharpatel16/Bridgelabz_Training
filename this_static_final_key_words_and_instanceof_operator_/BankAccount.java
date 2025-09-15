public class BankAccount {

    // ---------- STATIC ----------
    // Shared bank name across all accounts
    private static String bankName = "State Bank of India";

    // Count of all accounts (shared)
    private static int totalAccounts = 0;

    // ---------- FINAL ----------
    // Account number can't be changed once assigned
    private final String accountNumber;

    // ---------- INSTANCE ----------
    private String accountHolderName;
    private double balance;

    // ---------- CONSTRUCTOR (using 'this' to avoid ambiguity) ----------
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // final variable → assigned once
        this.balance = balance;
        totalAccounts++; // increment shared counter
    }

    // ---------- STATIC METHOD ----------
    public static void getTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    // ---------- INSTANCEOF + DISPLAY ----------
    public void displayAccountDetails() {
        if (this instanceof BankAccount) { // safe type check
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        } else {
            System.err.println("Invalid account instance.");
        }
    }

    // ---------- GETTERS & SETTERS ----------
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // ---------- UTILITY METHODS ----------
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.err.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.err.println("Insufficient balance or invalid amount.");
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        // Create accounts
        BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000.00);
        BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500.00);

        // Display details
        System.out.println("\nAccount 1 Details:");
        account1.displayAccountDetails();

        System.out.println("\nAccount 2 Details:");
        account2.displayAccountDetails();

        // Show total accounts
        BankAccount.getTotalAccounts();

        // Transactions
        System.out.println("\nPerforming transactions on Account 1:");
        account1.deposit(200);
        account1.withdraw(150);
        account1.displayAccountDetails();

        System.out.println("\nPerforming transactions on Account 2:");
        account2.displayAccountDetails();
        account2.deposit(100);
        account2.withdraw(800);
    }
}
