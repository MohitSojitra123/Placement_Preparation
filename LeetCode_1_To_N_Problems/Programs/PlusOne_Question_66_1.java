import java.util.*;

public class PlusOne_Question_66_1 {

    public static void main(String[] args) {

        int[] arr = {1, 9, 9};


        // 1. Array Convert into Single String
        String str = "";

        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
        }

        System.out.println("String: " + str);


        // 2. String Convert into Number
        int num = Integer.parseInt(str);

        System.out.println("Number: " + num);


        // 3. Add Plus One
        num = num + 1;

        System.out.println("After Plus One: " + num);


        // 4. Number Convert into String
        String result = String.valueOf(num);


        // 5. String Convert into Array Digits
        int[] newArr = new int[result.length()];

        for(int i = 0; i < result.length(); i++) {
            newArr[i] = result.charAt(i) - '0';
        }


        // Print Final Array
        System.out.print("Final Array: ");

        for(int i : newArr) {
            System.out.print(i + " ");
        }
    }
}