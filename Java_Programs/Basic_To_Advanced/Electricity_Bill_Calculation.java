// WAP That Finds Total Electricity Bill,input electricity unit charge and calculate the total electricity bill according To The given condition:

// For  First 50 Units Rs. O.50/Unit
// For  Next 100 Units Rs. O.75/Unit
// For  Next 100 Units Rs. 1.20/Unit
// For  Next 250 Units Rs. 1.50/Unit

import java.util.Scanner;

public class Electricity_Bill_Calculation {
    public static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter electricity units consumed: ");
        double units = sc.nextDouble();

        double totalBill = 0;


        if (units <= 50) {
            totalBill = units * 0.50;
        } else if (units <= 150) {
            totalBill = (50 * 0.50) + ((units - 50) * 0.75);
        } else if (units <= 250) {
            totalBill = (50 * 0.50) + (100 * 0.75) + ((units - 150) * 1.20);
        } else {
            totalBill = (50 * 0.50) + (100 * 0.75) + (100 * 1.20) + ((units - 250) * 1.50);
        }

        // Add 20% surcharge
        double surcharge = totalBill * 0.20;
        double finalBill = totalBill + surcharge;

        System.out.println("--------------------------------------------");
        System.out.println("Total Electricity Units: " + units);
        System.out.println("Base Bill Amount: Rs. " + totalBill);
        System.out.println("Surcharge (20%): Rs. " + surcharge);
        System.out.println("Final Bill Amount: Rs. " + finalBill);
        System.out.println("--------------------------------------------");

        sc.close();

    }
}
