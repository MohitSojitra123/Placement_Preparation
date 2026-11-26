// 11 Find if a given string can be represented from a substring by iterating the substring 
// “n” times. 
 
// Input: str = "abcabcabc" 
// Output: true 
 
// Input: str = "aabaabaabaab" 
// Output: true 
 
// Input: str = "abcdabc" 
// Output: false  

import java.util.Scanner;

public class Problem_11 {

    public static boolean check(String str) {

        int n = str.length();

        for (int len = 1; len <= n / 2; len++) {

            if (n % len == 0) {

                boolean flag = true;

                for (int i = len; i < n; i++) {

                    if (str.charAt(i) != str.charAt(i % len)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.nextLine();

        System.out.println(check(str));

        sc.close();
    }
}