import java.util.Scanner;

public class Prime_Factors {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         int user_num;

         System.out.println("Enter Any Number : ");
         user_num=sc.nextInt();

         System.out.println("Prime Factors : ");

         for(int i=2; i<=user_num; i++){
              if(user_num%i==0){
                  if(Prime_Factors.IsPrime(i)){
                      System.out.println(i);
                    }
                }
         }

    }

    static boolean IsPrime(int n){
             for(int i=2; i<n; i++){
                   if(n%i==0){
                      return false;
                   }
             }
             return true; 
    }
}
