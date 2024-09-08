package com.interviewprep.exception_handling.exception_propagation;

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String message) {
    super(message);
  }
}

class BankAccount {
  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient funds for withdrawal.");
    }
    balance -= amount;
  }

  public double getBalance() {
    return balance;
  }
}

public class ExceptionPropagation2 {
  public static void main(String[] args) {
    BankAccount account = new BankAccount(500.0);

    try {
      processWithdrawal(account, 600.0);
    } catch (InsufficientFundsException e) {
      System.out.println("Withdrawal failed: " + e.getMessage());
      // Handle the error by notifying the user, logging the transaction, etc.
    }
  }

  public static void processWithdrawal(BankAccount account, double amount) throws InsufficientFundsException {
    // This method knows what to do if the withdrawal fails
    account.withdraw(amount);
    System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
  }
}

