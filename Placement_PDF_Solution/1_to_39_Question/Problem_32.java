// 32 Given  an  integer  array  arr[]  containing  digits  from  [0,  9],  the  task  is  to  print  all 
// possible letter combinations that the numbers could represent. A mapping of digits 
// to letters (just like on the telephone buttons) is being followed. Note that 0 and 1 do 
// not map to any letters. All the mapping are shown in the image below:  
// Input: arr[] = [2, 3] 
// Output: ad ae af bd be bf cd ce cf  
// Explanation: When we press 2,3 then ad, ae, af, bd,  ... cf are the list of possible words.  
// Input: arr[] = [5] 
// Output: j  k  l 
// Explanation: When we press 5 then j, k, l are the list of possible words

import java.util.*;

public class Problem_32 {

    public static void main(String[] args) {

        int[] arr = {2, 3};

        String[] keypad = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();

        result.add("");

        for (int digit : arr) {

            String letters = keypad[digit];

            List<String> temp = new ArrayList<>();

            for (String str : result) {

                for (char ch : letters.toCharArray()) {
                    temp.add(str + ch);
                }
            }

            result = temp;
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}