import java.util.HashSet;
import java.util.Scanner;

public class Happy_Number {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Any Number To Check Number Is Empty or Not : ");
         int num=sc.nextInt();

         HashSet<Integer> hs=new HashSet<>();

         while (num!=1) {
               
            if(hs.contains(num)){
                  break;
            }

            hs.add(num);

            int happy_number=0;

            while (num!=0) {
                 int last_digit=num%10;
                 happy_number+=last_digit*last_digit;
                 num/=10; 
            }
            num=happy_number;
         }

     if(num==1){
        System.out.println(" Happy  Number : ");
     }else{
        System.out.println("Not Happy Number : ");
     }

    }
}
