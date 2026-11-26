// Write a Java program to create a class called BankAccount with instance variables
// 'accountNo' and balance, and static variables bankName and interestRate. Implement
// static methods to get and set the static variables. Create three BankAccount objects and
// print their details along with the static variables. [A]

import java.util.Scanner;

class bankaccount{
    
    static  String bank_name;
    static  int bank_interest;
    String bank_number;
    double bank_balance;
    
     static  void setbankname(){
         Scanner sc=new Scanner(System.in);      
        System.out.println("Enter Bank Name => ");
         bank_name=sc.nextLine(); 
        }
        
        static void setbankinterest(){
            Scanner sc=new Scanner(System.in);
        System.out.println("Enter Bank Interest Reate => ");
       bank_interest=sc.nextInt();
    }

    void setAccountNo_AccountBalance(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Bank Account Number => ");
        this.bank_number=sc.nextLine();
        System.out.println("Enter Bank Account Balance => ");
        this.bank_balance=sc.nextDouble();
        System.out.println("-------------------------------");
    }

   static void ShowAllDetail(){
           System.out.println("-------------------------------------");
           System.out.println("Bank Name => "+bank_name);
           System.out.println("Bank interest => "+bank_interest);
           System.out.println("-------------------------------------");
    }

    
    void ShowAllDetail_Account(){
           System.out.println("-------------------------------------");
           System.out.println("Bank Name => "+bank_name);
           System.out.println("Bank interest => "+bank_interest);
            System.out.println("Bank number => "+bank_number);
           System.out.println("Bank balance => "+bank_balance);
           System.out.println("-------------------------------------");
    }
}

public class program_3 {
    public static void main(String[] args) {
     
         bankaccount bank=new bankaccount();
         bank.setbankname(); 
         bank.setbankinterest();


         bankaccount[] b1=new bankaccount[3];


         System.out.println("--------------------------------");
         
         for(int i=0; i<3; i++){
             b1[i] = new bankaccount();
             b1[i].setAccountNo_AccountBalance();
            }

            System.out.println("--------------------------------");

         for(int i=0; i<3; i++){
            b1[i].ShowAllDetail();
         }
   

    }
}
