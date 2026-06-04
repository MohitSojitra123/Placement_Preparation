// 10 Given a string S and a character ‘c’, the task is to count the occurrence of the given 
// character in the string. 
 
// Input: S = “geeksforgeeks” and c = ‘e’ 
// Output: 4 
// Explanation: ‘e’ appears four times in str. 
// Input: S = “abccdefgaa” and c = ‘a’ 
// Output: 3 
// Explanation: ‘a’ appears three times in str.

import java.util.Scanner;

public class Problem_10 {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter String : ");
          String str=sc.nextLine();

          str=str.toLowerCase();

          char ch[]=str.toCharArray();

          System.out.println("Enter Character To Count Number Of Occurence : ");
         char user=sc.nextLine().charAt(0);

         user=Character.toLowerCase(user);


         int count=0;

          for(int i=0; i<ch.length; i++){
              if(ch[i]==user){
                count++;
              }
          }

          System.out.println("Number Of Occurence : "+count);

    }
}
