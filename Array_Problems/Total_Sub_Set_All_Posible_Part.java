import java.util.Scanner;

public class Total_Sub_Set_All_Posible_Part{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array input from user
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Array Element: ");
            arr[i] = sc.nextInt();
        }

        // Calculate total subsets = 2^n
        int totalSubsets = 1 << n; // same as 2^n

        System.out.println("\nAll subsets (" + totalSubsets + " possibilities):");

        // Loop through all subset masks
        for (int mask = 0; mask < totalSubsets; mask++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
