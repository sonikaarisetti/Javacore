//27. Write a program to create an interface called account operation with methods deposit(), getBalance().
//Implement this interface in Account class.
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(double balance, double amount) {
        super("Insufficient Balance " + balance + " for withdrawal of " + amount);
    }
}

interface AccountOperation {
    void deposit(double amount);   // deposit money
    double getBalance();           // get current balance
}

class Account implements AccountOperation {
    private double balance;

    Account(double initialBalance) {
        balance = initialBalance;
    }

    public void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new InsufficientBalanceException(balance, amount);
            }
            balance -= amount;
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}


public class TestAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account with initial balance 1000
        Account acc = new Account(1000);

        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        acc.deposit(amt);
        acc.withdraw(2000);
        System.out.println("Current balance: " + acc.getBalance());

        sc.close();
    }
}