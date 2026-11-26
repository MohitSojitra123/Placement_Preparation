public class Union_Of_Two_Arrays {
    public static void main(String[] args) {

        int array1[] = {10, 20, 40, 50, 60};
        int array2[] = {10, 20, 30, 60};

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        for (int i = 0; i < array2.length; i++) {

            boolean found = false;

            for (int j = 0; j < array1.length; j++) {
                if (array2[i] == array1[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.print(array2[i] + " ");
            }
        }
    }
}