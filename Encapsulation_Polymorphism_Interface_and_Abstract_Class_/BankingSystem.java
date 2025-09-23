package PolymorphismAbstractionInterface_Problems;
interface Loanable {
 void applyForLoan(double amount);
 boolean calculateLoanEligibility();
}
abstract class BankAccount {
 private String accountNumber;
 private String holderName;
 private double balance;

 public BankAccount(String accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
 }
 public String getAccountNumber() { return accountNumber; }
 public String getHolderName() { return holderName; }
 public double getBalance() { return balance; }

 public void deposit(double amount) { balance += amount; }
 public void withdraw(double amount) { if (balance >= amount) balance -= amount; }

 public abstract double calculateInterest();
}
class SavingsAccount extends BankAccount implements Loanable {
 public SavingsAccount(String accNo, String name, double bal) {
     super(accNo, name, bal);
 }

 @Override
 public double calculateInterest() {
     return getBalance() * 0.04; 
 }

 @Override
 public void applyForLoan(double amount) {
     System.out.println("Loan applied for Savings Account: " + amount);
 }

 @Override
 public boolean calculateLoanEligibility() {
     return getBalance() >= 5000;
 }
}

class CurrentAccount extends BankAccount implements Loanable {
 public CurrentAccount(String accNo, String name, double bal) {
     super(accNo, name, bal);
 }

 @Override
 public double calculateInterest() {
     return getBalance() * 0.02; 
 }

 @Override
 public void applyForLoan(double amount) {
     System.out.println("Loan applied for Current Account: " + amount);
 }

 @Override
 public boolean calculateLoanEligibility() {
     return getBalance() >= 10000;
 }
}
public class BankingSystem {
 public static void main(String[] args) {
     BankAccount[] accounts = {
         new SavingsAccount("S001", "Alice", 6000),
         new CurrentAccount("C002", "Bob", 15000)
     };

     for (BankAccount acc : accounts) {
         System.out.println("Account Holder: " + acc.getHolderName());
         System.out.println("Interest: " + acc.calculateInterest());

         if (acc instanceof Loanable) {
             Loanable loanAcc = (Loanable) acc;
             loanAcc.applyForLoan(5000);
             System.out.println("Eligible: " + loanAcc.calculateLoanEligibility());
         }
         System.out.println(" ");
     }
 }
}

