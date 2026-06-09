package Day_1;
import java.util.Scanner;

public class Factor_of_Number {
    public static void main(String[] args) {
  
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number To Find Factors : ");
        int num=sc.nextInt();


        for(int i=1; i<=num; i++){
            if(num%i==0){
                  System.out.print(i+" ");
            }
        }
          
  
    }
}
