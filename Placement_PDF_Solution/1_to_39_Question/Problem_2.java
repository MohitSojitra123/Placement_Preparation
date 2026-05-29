// Given two strings s1 and s2 consisting of lowercase characters, the task is to check 
// whether the two given strings are anagrams of each other or not. An anagram of a 
// string is another string that contains the same characters, only the order of characters 
// can be different. 
 
// Input: s1 = “geeks”  s2 = “kseeg” 
// Output: true 
// Explanation:  Both  the  strings  have  the  same  characters  with  same  frequency.  So, 
// they are anagrams. 
 
// Input: s1 = “allergy”  s2 = “allergic” 
// Output: false 
// Explanation: Characters in both the strings are not the same. s1 has extra characters 
// ‘y’ and s2 has extra characters ‘i’ and ‘c’, so they are not anagrams.

import java.util.Arrays;

public class Problem_2 {
    public static void main(String[] args) {
        

        String s1 = "lissten";
        String s2 = "silent";

        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();

        for(int i=0; i<ch1.length-1; i++){
            for(int j=0; j<ch1.length-1-i; j++){
                if(ch1[j]>ch1[j+1]){
                       char temp=ch1[j];
                       ch1[j]=ch1[j+1];
                       ch1[j+1]=temp;
                }
            }
        }

        for(int i=0; i<ch2.length-1; i++){
            for(int j=0; j<ch2.length-1-i; j++){
                if(ch2[j]>ch2[j+1]){
                       char temp=ch2[j];
                       ch2[j]=ch2[j+1];
                       ch2[j+1]=temp;
                }
            }
        }

        String str1=new String(ch1);
        String str2=new String(ch2);

        if(str1.equals(str2)){
            System.out.println("Anagram String : ");
        }else{
            System.out.println("Not Anagram String : ");
        }

    }
}
