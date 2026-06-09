package Day_1;
import java.util.Scanner;

public class Electrisity_Bill {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);


        System.out.println("Enter Total Unit : ");
        int unit=sc.nextInt();

        double total;

        if(unit<=50){
              total=unit*2.6;
        }else if (unit <=100  ) {
             total = (50*2.6)  + ((unit-50) * 3.25); 
        }else if ( unit <=200){
            total = (50*2.6)  + ((50) * 3.25)  + ((unit-100) * 5.26);
        }else  {
            total = (50*2.6)  + ((50) * 3.25)  + ((100) * 5.26) +  ((unit-200) * 7.25);
        }


        System.out.println("Total Charge : "+total);


    }
}
