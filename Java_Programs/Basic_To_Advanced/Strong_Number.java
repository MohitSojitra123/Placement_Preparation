// A Strong Number is a number where the sum of the factorial of its digits is equal to the number itself.

// Definition
// A number is Strong if:
// Number
// =
// sum of factorial of its digits
// Number=sum of factorial of its digits
// Example 1
// Number = 145
// Digits: 1, 4, 5
// Factorial:
// 1! = 1
// 4! = 24
// 5! = 120
// Sum = 1 + 24 + 120 = 145
// ✅ 145 = 145
// So 145 is a Strong Number

// Example 2
// Number = 2
// 2! = 2
// ✅ 2 = 2
// So 2 is also a Strong Number

// Example 3
// Number = 123
// Factorial:
// 1! = 1
// 2! = 2
// 3! = 6
// Sum = 1 + 2 + 6 = 9
// ❌ 9 ≠ 123
// So 123 is NOT a Strong Number

// Common Strong Numbers
// 1, 2, 145, 40585

import java.util.Scanner;

public class Strong_Number {

       static int Factorial_num(int num){
           int factorial=1;
           for(int i=1; i<=num; i++){
            factorial=factorial*i;
           }

           return factorial;
       }
     public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter Any Number To Check Number Is Strong Or Not : ");
           int num=sc.nextInt();

           int Temp=num;
           int sum=0;

           while (Temp!=0) {
               int lastDigit=Temp%10;
               sum+=Factorial_num(lastDigit);
               Temp/=10;
           }

           if(sum==num){
              System.out.println("Number Is Strong : ");
           }else{
            System.out.println("Number Is Not Strong : ");
           }


     }
}

