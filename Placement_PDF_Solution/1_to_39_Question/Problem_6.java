// 6 Given  the  principal  amount  (P),  rate  of  interest  per  annum  (R),  and  loan  tenure  in 
// months (N), write a program to calculate the EMI (Equated Monthly Installment) for 
// a loan. 
 
// Input : Enter principal amount (P): 500000 
//              Enter annual interest rate (R): 7.5 
//              Enter loan tenure in months (N): 60 
// Output: The EMI per month is: 10013.05


import  java.util.Scanner;

public class Problem_6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal Amount (P): ");
        double P = sc.nextDouble();

        System.out.print("Enter Annual Interest Rate (R): ");
        double R = sc.nextDouble();

        System.out.print("Enter Loan Tenure in Months (N): ");
        int N = sc.nextInt();


        double r = R / (12 * 100);

        double EMI =
                (P * r * Math.pow(1 + r, N))
                /
                (Math.pow(1 + r, N) - 1);

        System.out.printf("The EMI per month is: %.2f", EMI);

        sc.close();
    }
}