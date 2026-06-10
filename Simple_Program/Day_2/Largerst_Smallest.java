package Day_2;

import java.util.Scanner;

public class Largerst_Smallest {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number : ");
        int num=sc.nextInt();

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        while (num!=0) {
            
            int current_num=num%10;

            if(current_num>max){
                max=current_num;
            }

            if(current_num<min){
                min=current_num;
            }

            num/=10;
        }


        System.out.println("Min : "+min);
        System.out.println("Max : "+max);

    }
}
