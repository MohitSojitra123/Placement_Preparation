// WAP to find Max, Min, Average of n numbers, n should be taken from user and all n value 
// should be taken from user (Note that you are not allowed to use an array for this) 

import java.util.Scanner;

public class Problem_12 {
    public static void main(String[] args) {
      
          Scanner sc=new Scanner(System.in);

          int max=Integer.MIN_VALUE;
          int min=Integer.MAX_VALUE;
          int sum=0,count=0,num=0;

          while (true) {
            
            System.out.println("Enter Number : ( -1 : Exit )");
            num=sc.nextInt();

            if(num==-1){
                break;
            }else{

                if(num>max){
                    max=num;
                }

                if(num<min){
                    min=num;
                }
                
                sum+=num;
                count++;
            }

          }

          System.out.println("Min : "+min);
          System.out.println("Max : "+max);
          System.out.println("Avg : "+(sum/count));

        
    }
}
