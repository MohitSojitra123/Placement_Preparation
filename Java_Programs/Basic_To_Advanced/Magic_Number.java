import java.util.Scanner;

public class Magic_Number {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         
         System.out.println("Enter Number : ");
         int num=sc.nextInt();

         int sum=num;
         int temp=0;

         while (sum>9){
                temp=0;
                
                while (num!=0) {
                      temp+=num%10;
                      num/=10; 
                }
                sum=temp;
                num=sum;
         }
        
         if(sum==1){
                System.out.println("Number Is Magic : ");
         }else {
                System.out.println("Number Is Not Magic");
         }

    }
}

// 1. 7
// 7 → single digit already
// 7 ≠ 1 → ❌ Not Magic Number

// 2. 10
// 1 + 0 = 1 → ✅ Magic Number

// 3. 28
// 2 + 8 = 10
// 1 + 0 = 1 → ✅ Magic Number

// 4. 121
// 1 + 2 + 1 = 4 → ❌ Not Magic Number

// 5. 986
// 9 + 8 + 6 = 23
// 2 + 3 = 5 → ❌ Not Magic Number

// 6. 199
// 1 + 9 + 9 = 19
// 1 + 9 = 10
// 1 + 0 = 1 → ✅ Magic Number

// 7. 1234
// 1 + 2 + 3 + 4 = 10
// 1 + 0 = 1 → ✅ Magic Number

// 8. 56
// 5 + 6 = 11
// 1 + 1 = 2 → ❌ Not Magic Number