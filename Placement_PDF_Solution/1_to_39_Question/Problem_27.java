// 27 Write  a  program  to  sort  the  numbers  in  a  string  expression  where  numbers  are 
// separated  by  the  '+'  sign.  The  program  should  rearrange  the  numbers  in  non-
// decreasing order while keeping them separated by '+'. 
// Input: 3+2+1   
// Output: 1+2+3 
 
// Input: 1+1+3+1+3   
// Output: 1+1+1+3+3

import java.util.Arrays;

public class Problem_27 {
    public static void main(String[] args) {
     
        String str="1+1+3+1+3+2";

        String s[]=str.split("\\+");

        int arr[]=new int[s.length];

        for(int i=0; i<s.length; i++){
               arr[i]= Integer.parseInt(s[i]);
        }

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                   if(arr[j]>arr[j+1]){
                       int temp=arr[j];
                       arr[j]=arr[j+1];
                       arr[j+1]=temp;
                   }
            }
        }

     StringBuilder sb=new StringBuilder();

     for(int i=0; i<arr.length-1; i++){
         sb.append(arr[i]+"+"); 
     }

     sb.append(arr[arr.length-1]);
     
     System.out.println(sb);
        
    }
}
