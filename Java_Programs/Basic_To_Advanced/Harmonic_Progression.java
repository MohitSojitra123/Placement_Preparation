import java.util.Scanner;

public class Harmonic_Progression {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Term : ");
        int a = sc.nextInt();

        System.out.print("Enter Common Difference : ");
        int d = sc.nextInt();

        System.out.print("Enter Number of Terms : ");
        int n = sc.nextInt();

        System.out.println("Harmonic Progression:");

        for(int i=0; i<n; i++){

            int apTerm = a + (i * d);

            System.out.print("1/" + apTerm + " ");
        }
    }
}