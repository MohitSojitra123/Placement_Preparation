// Create class BankDemo and Account(accNum:int, accType:String, balance: double).
// Implement getter() and setter() method to assign and display data for 3 students.[

class BankDemo{

       int account_number;
       double account_balance;
       String account_type;
 
     public void setter(int acc_number, String acc_type,double balance){
          this.account_number=acc_number;
          this.account_type=acc_type;
          this.account_balance=account_balance;
     }

     public void getter(){
          System.out.println("-----------------------------");
          System.out.println("Account Number => "+this.account_number);
          System.out.println("Account Balance => "+this.account_balance);
          System.out.println("Account Type => "+this.account_type);
          System.out.println("-----------------------------");
     }

}

public class Program_3 {
     public static void main(String[] args) {
        
            BankDemo b1=new BankDemo();
            BankDemo b2=new BankDemo();
         
            b1.setter(3485308, "Saving", 4582.90);
            b2.setter(543853, "Current", 68532.34);

            b1.getter();
            b2.getter();

     }
}
