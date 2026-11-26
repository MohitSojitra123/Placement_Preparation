// Find a next lexicographical order string from a given string, if input is abc output is acb (2 conditions must 
// be  followed:  the  string must be  greater  than  the  inputted  string  and  the  outputted  string  must be the 
// smallest string from all possible strings).

import java.util.Scanner;

public class Question_44 {

    public static String nextPermutation(String str) {

        char[] arr = str.toCharArray();
        int n = arr.length;

        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) {
            return "No next permutation";
        }

        int j = n - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.next();

        System.out.println("Next Lexicographical String : " + nextPermutation(str));

        sc.close();
    }
}