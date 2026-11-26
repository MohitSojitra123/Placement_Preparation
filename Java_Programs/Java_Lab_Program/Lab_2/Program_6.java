//  Write a program that prompts the user to enter a letter and check whether a letter is a
// vowel or a constant.

import java.util.Scanner;

public class Program_6 {
      public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter Any Character To Check Character Is Vowel Or Constant => ");
           char ch=sc.nextLine().charAt(0);

           ch=Character.toLowerCase(ch);

           if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                     System.out.println("Character Is Vowel => "+ch);
           }else{
                     System.out.println("Character Is Constant => "+ch);
           }
        }
}
