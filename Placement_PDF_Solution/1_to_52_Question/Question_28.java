// Write a program that should decode the given pattern and print the resulting expanded string. 
// Input: 2a3bc4dE5F2G7H 
// Output: aabbbcddddEFFFFFGGHHHHHHH

public class Question_28 {
    public static void main(String[] args) {
        
        String str="2a3bc4dE5F2G7H";

        for(int i=0; i<str.length(); i++){
               
            if(Character.isDigit(str.charAt(i))){
                  int n=str.charAt(i)-'0';

                  for(int j=1; j<=n; j++){
                      System.out.print(str.charAt(i+1));
                  }
                  i++;
               }else{
                System.out.print(str.charAt(i));
               }

        }

    }
}
