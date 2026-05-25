// 8. Number with Given Factor Count
// Find smallest number having k factors

// Example
// k = 4

// 6 → factors (1,2,3,6)
// 8 → factors (1,2,4,8)

// Output → 6

import java.util.Scanner;

public class Find_Kth_Smallest_Facotor {

      static int  Count_Factor(int num){
        int count=0;
        for(int i=1; i<=num; i++){
            if(num%i==0){
                  count++;
            }
        }
        return count;
      }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Kth Factor Smaller Number : ");
        int Kth=sc.nextInt();

         int num=1;

        while (true) {
                if(Find_Kth_Smallest_Facotor.Count_Factor(num)==Kth){
                     System.out.println("Small Kth Factor Is "+num); 
                    break;
                }
                num++;
        }

    }
}
