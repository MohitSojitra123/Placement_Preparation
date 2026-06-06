// 24 Write a Program to Check Whether a String is a Palindrome or Not.  
// Input: s = “level” 
// Output: True  
// Input: s = “Geeks” 
// Output: False

public class Problem_24 {
    public static void main(String[] args) {
        
          String str="gedel";

          StringBuilder sb=new StringBuilder(str).reverse();


          if (str.equals(sb.toString())) {
              System.out.println("Palindrom String : ");
          }else{
            System.out.println("Not Palindrom String :");
          }



    }
}
