package Lab_10;

import java.util.Scanner;

// Write a Java program to create an abstract class BankAccount with abstract methods 
// deposit() and withdraw(). Create subclasses: SavingsAccount and CurrentAccount that 
// extend  the  BankAccount  class  and  implement  the  respective      methods  to  handle 
// deposits and withdrawals for each account type.[A] 

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;


    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-----------------------------------");
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate = 0.05; 

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Savings Account");
        balance += balance * interestRate;
        System.out.println("Interest applied: " + (amount * interestRate));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from Savings Account");
        } else {
            System.out.println("Insufficient balance in Savings Account!");
        }
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Current Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from Current Account");
        } else {
            System.out.println("Insufficient balance in Current Account!");
        }
    }
}


public class Program_2 {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV123", 1000);
        CurrentAccount ca = new CurrentAccount("CUR456", 2000);


        sa.displayBalance();
        ca.displayBalance();


        sa.deposit(500);
        sa.withdraw(200);
        sa.displayBalance();

        ca.deposit(1000);
        ca.withdraw(3500);
        ca.displayBalance();
    }
}
