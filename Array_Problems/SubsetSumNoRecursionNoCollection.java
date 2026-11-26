public class SubsetSumNoRecursionNoCollection {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50,60};
        int n = arr.length;
        int target = 60;

        // Total possible subsets = 2^n
        int totalSubsets = 1;
        for (int i = 0; i < n; i++) {
            totalSubsets = totalSubsets * 2;
        }

        // Store subsets
        int[][] subset = new int[totalSubsets][n];
        int[] size = new int[totalSubsets];

        int subsetCount = 1; // empty subset already exists

        for (int i = 0; i < n; i++) {

            int currentCount = subsetCount;

            for (int j = 0; j < currentCount; j++) {

                // Copy old subset
                for (int k = 0; k < size[j]; k++) {
                    subset[subsetCount][k] = subset[j][k];
                }

                // Add current element
                subset[subsetCount][size[j]] = arr[i];
                size[subsetCount] = size[j] + 1;

                subsetCount++;
            }
        }

        // Print valid subsets
        System.out.println("Valid combinations:");
        for (int i = 1; i < subsetCount; i++) {
            int sum = 0;
            for (int j = 0; j < size[i]; j++) {
                sum += subset[i][j];
            }

            if (sum == target) {
                for (int j = 0; j < size[i]; j++) {
                    System.out.print(subset[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// import java.util.Scanner;

// public class AllSubsetsEasy {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter Array Size: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter Array Element: ");
//             arr[i] = sc.nextInt();
//         }

//         // Total possible subsets = 2^n
//         int totalSubsets = 1;
//         for (int i = 0; i < n; i++) {
//             totalSubsets *= 2;
//         }

//         // Store subsets in 2D array
//         int[][] subset = new int[totalSubsets][n];
//         int[] size = new int[totalSubsets];

//         int subsetCount = 1; // empty subset already exists

//         for (int i = 0; i < n; i++) {
//             int currentCount = subsetCount;
//             for (int j = 0; j < currentCount; j++) {
//                 // Copy old subset
//                 for (int k = 0; k < size[j]; k++) {
//                     subset[subsetCount][k] = subset[j][k];
//                 }
//                 // Add current element
//                 subset[subsetCount][size[j]] = arr[i];
//                 size[subsetCount] = size[j] + 1;

//                 subsetCount++;
//             }
//         }

//         // Print all subsets
//         System.out.println("\nAll subsets (" + totalSubsets + " possibilities):");
//         for (int i = 0; i < subsetCount; i++) {
//             System.out.print("{ ");
//             for (int j = 0; j < size[i]; j++) {
//                 System.out.print(subset[i][j] + " ");
//             }
//             System.out.println("}");
//         }
//     }
// }

