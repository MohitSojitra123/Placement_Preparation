import java.util.Scanner;

public class Sunny_Number {
    public static void main(String[] args) {
          // Check if number is sunny number

// 0 → 0 + 1 = 1 → 1 = 1² → ✅ Sunny Number
// 3 → 3 + 1 = 4 → 4 = 2² → ✅ Sunny Number
// 5 → 5 + 1 = 6 → not a perfect square → ❌ Not Sunny
// 15 → 15 + 1 = 16 → 16 = 4² → ✅ Sunny Number
// 24 → 24 + 1 = 25 → 25 = 5² → ✅ Sunny Number
// 26 → 26 + 1 = 27 → not a perfect square → ❌ Not Sunny
// 80 → 80 + 1 = 81 → 81 = 9² → ✅ Sunny Number
// 120 → 120 + 1 = 121 → 121 = 11² → ✅ Sunny Number

           Scanner sc=new Scanner(System.in);

           System.out.println("Enter Any Number To Check Number Is Sunnyy Number Or Not !");
           int user=sc.nextInt();

           int next_user=user+1;

           int sqrt_user=(int)Math.sqrt(next_user);

           System.out.println("Next User Number => "+next_user);
           System.out.println("sqrt Number => "+sqrt_user);

           if((sqrt_user*sqrt_user) == next_user){
            System.out.println("Number Is Sunny Number "+user);
           }else{
            System.out.println("Number Is Not Sunnyy Number "+user);
           }


    }
}
