package Inheritance;

// Rename superclass to avoid conflict
class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// SavingsAccount subclass
class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends Account {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends Account {
    int duration;

    FixedDepositAccount(String accountNumber, double balance, int duration) {
        super(accountNumber, balance);
        this.duration = duration;
    }

    void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Duration: " + duration + " months");
    }
}

// Main class stays BankAccount
public class BankAccount {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA1001", 5000, 5.0);
        CheckingAccount checking = new CheckingAccount("CA1002", 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD1003", 10000, 12);

        Account[] accounts = {savings, checking, fixedDeposit};

        System.out.println("=== Bank Account System ===\n");

        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).displayAccountType();
            } else if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).displayAccountType();
            } else if (acc instanceof FixedDepositAccount) {
                ((FixedDepositAccount) acc).displayAccountType();
            }
            System.out.println("-----------------------------\n");
        }
    }
}
