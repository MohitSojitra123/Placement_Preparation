// You are given an integer num. Rearrange the digits of num such that its value is minimized 
// and it does not contain any leading zeros. 
// Return the rearranged number with minimal value. 
// Note that the sign of the number does not change after rearranging the digits. 
// Input: num = 310 
// Output: 103 
// Explanation:  The  possible  arrangements  for  the  digits  of  310  are  013,  031,  103,  130,  301, 
// 310.  
// The arrangement with the smallest value that does not contain any leading zeros is 103. 

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_41 {

    public static void main(String[] args) {
        
 
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Rearrange Smallest Number : ");
        int num=sc.nextInt();

        String num_str=Integer.toString(num);

        char ch[]=num_str.toCharArray();


        System.out.println(Arrays.toString(ch));

        for(int i=0; i<ch.length-1; i++){
            for(int j=0; j<ch.length-1-i; j++){
                if(ch[j]>ch[j+1]){
                    char temp=ch[j];
                    ch[j]=ch[j+1];
                    ch[j+1]=temp;
                }
            }
        }
        
        System.out.println(Arrays.toString(ch));
        
        if(ch[0]=='0'){
            for(int i=1; i<ch.length; i++){
                if(ch[i]!='0'){
                    ch[0]=ch[i];   
                    ch[i]='0';
                    break;
                }
            }
        }
        
        String str=new String(ch);

        System.out.println(Integer.parseInt(str));

    }
    
}