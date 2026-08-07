public class Equilibrium_Index_1 {

    public static int findEquilibriumIndex(int[] arr) {

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            totalSum = totalSum - arr[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum = leftSum + arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 2, 2};

        int index = findEquilibriumIndex(arr);

        System.out.print("Array : ");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        if (index != -1) {
            System.out.println("Equilibrium Index : " + index);
        } else {
            System.out.println("No Equilibrium Index Found");
        }
    }
}
