// Kth Factor 
// intput 6 
// find 3 Factor
// Total Factor Is 1 2 3 6  
// Ans ==> 3 

import java.util.Scanner;

public class Kth_Factor {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Any Number : ");
          int num=sc.nextInt();

          System.out.println("Enter Kth Factro To Print : ");
          int kth=sc.nextInt();

          int count=1;
          boolean find_kth=false;

          for(int i=1; i<=num; i++){
              if(num%i==0){
                 if(kth==count){
                     System.out.println("Kth Facot Is "+i);
                     find_kth=true; 
                     break;
                 }
                 count++;
              }
          }

          if(!find_kth){
            System.out.println("Not Kth Factor Present : ");
          }


    }
}
