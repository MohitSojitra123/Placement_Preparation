// WAP to find weather given number is Kaprekar or not. 
// A Kaprekar number is a non-negative integer that, when squared, can be split into two parts whose sum 
// equals the original number.  
// For E.g. 45 is a Kaprekar number because 45 squared (2025) can be split into 20 and 25, and 20 + 25 = 45

import java.util.Scanner;

public class Question_3 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number To Check Number Is Kaperaker Number Or Not :  ");
       int num=sc.nextInt();

       int squre_num=num*num;

       int num_length=0;

       int temp = num;

       while (temp!=0) {
          num_length++;
          temp/=10;
       }

       String str=Integer.toString(squre_num);

       String group_1=str.substring(0,num_length);
       String group_2=str.substring(num_length);

       int a1=Integer.parseInt(group_1);
       int a2=Integer.parseInt(group_2);

       if((a1+a2)==num){
        System.out.println("Number Is Kaperaker : ");
       }else{
        System.out.println("Number Is Not Kaperaker : ");
       }

    }
}
