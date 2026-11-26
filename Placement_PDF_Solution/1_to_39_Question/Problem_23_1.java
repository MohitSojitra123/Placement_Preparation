// 23 Given  an  integer  n,  find  whether  the  number  is  Palindrome  or  not.  A  number  is  a 
// Palindrome if it remains the same when its digits are reversed.  
// Input: n = 12321 
// Output: Yes 

public class Problem_23_1 {
  public static void main(String[] args) {
    
    int n = 12321;

        String original = String.valueOf(n);
        String reversed = new StringBuilder(original).reverse().toString();

        if (original.equals(reversed)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

  }
}