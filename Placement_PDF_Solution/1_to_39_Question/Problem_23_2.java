// public 23 Given  an  integer  n,  find  whether  the  number  is  Palindrome  or  not.  A  number  is  a 
// Palindrome if it remains the same when its digits are reversed.  
// Input: n = 12321 
// Output: Yes 

public class Problem_23_2 {
    public static void main(String[] args) {
        
           
        int num=12321;


        int original_num=num;
        int reverse_num=0;

        while (num!=0) {
            reverse_num=(reverse_num*10)+num%10;
            num/=10;  
        }

        if(reverse_num==original_num  ){
             System.out.println("Palindrom Number : ");
            }else{
            System.out.println("Not Palindrom Number : ");
        }

    }
}
