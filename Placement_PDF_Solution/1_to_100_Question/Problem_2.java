// WAP to find whether string is palindrome or not.

public class Problem_2 {
    public static void main(String[] args) {
        
          String str="qwertewq";

          int start=0;
          int end=str.length()-1;

          boolean isPalindrom=true;

          while (start<=end) {
                if(str.charAt(start)!=str.charAt(end)){
                    isPalindrom=false;
                    break;
                }
                start++;
                end--;
          }

          if(isPalindrom){
            System.out.println("String Is Palindrom : ");
          }else{
            System.out.println("String Is Not Palindrom : ");
          }

    }
}
