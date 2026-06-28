// Write a program to create Account class, which is representing a bank account where
// we can deposit and withdraw money. If user need to withdraw money which exceed
// our minimum bank balance then it will not be allowed, and will throw
// InSufficientFundException(Custom Exception). Handle above exception and display
// proper error message. [A]



class InSufficientFundException extends Exception {
    public InSufficientFundException(String message) {
        super(message);
    }
}


class Account {
    double balance;
    double minimumBalance = 1000;


    public Account(double balance) {
        this.balance = balance;
    }

 
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited Amount : " + amount);
        System.out.println("Current Balance : " + balance);
    }


    public void withdraw(double amount) throws InSufficientFundException {

        if ((balance - amount) < minimumBalance) {
            throw new InSufficientFundException(
                "Withdrawal not allowed! Minimum balance should be Rs. " + minimumBalance
            );
        }

        balance = balance - amount;

        System.out.println("Withdraw Amount : " + amount);
        System.out.println("Remaining Balance : " + balance);
    }
}


public class Program_2 {
    public static void main(String[] args) {

        Account a1 = new Account(5000);
        a1.deposit(2000);

        try {
            a1.withdraw(5500);
        }
        catch (InSufficientFundException e) {
            System.out.println("Custom Exception Caught!");
            System.out.println(e.getMessage());
        }
    }
}