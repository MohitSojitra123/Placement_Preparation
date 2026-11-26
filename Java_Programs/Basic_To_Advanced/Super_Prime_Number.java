import java.util.Scanner;

public class Super_Prime_Number {
    public static void main(String[] args) {
        // Generate Super-prime numbers
        Scanner sc=new Scanner(System.in);  
        
        System.out.println("Enter Any Number to check number is Super Prime Number Or Not");
        int user_number=sc.nextInt();
        System.out.println("--------------------------------------");

        int position=1;

          for(int i=1; i<=user_number; i++){
              if(Super_Prime_Number.check_prime_number(i)){
                   if(Super_Prime_Number.check_prime_number(position)){
                       System.out.println(" Prime Number  => "+i+"  Prime Number Index => "+position);
                       System.out.println("-------------------------------------------");
                       position++; 
                   }else{
                       position++;
                   }
              }
          }
     
    }

     static boolean check_prime_number(int num){
        int count=0;
        
        for(int i=1; i<=num; i++){
             if(num%i==0){
                count++;
             }
        }       

        if(count==2){
             return true;
        }else{
            return false;
        }

    }

}
