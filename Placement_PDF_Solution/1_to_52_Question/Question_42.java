// Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]. 
// Input: n = 11 => Output: 0 
// Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the 
// number 10.

import java.util.Scanner;

public class Question_42 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Position : ");
        int n = sc.nextInt();

        String str="";
        int num = 1;

        while (str.length() < n) {
            str += num;
            num++;
        }

        System.out.println("Digit = " + str.charAt(n - 1));
    }
}