import java.util.HashSet;

public class Unique_Element_Two_Array {
  public static void main(String[] args) {

     int array1[] = {10, 20, 40, 50, 60};
        int array2[] = {10, 20, 30, 60};

        int i = 0, j = 0;

        while (i < array1.length && j < array2.length) {

            if (array1[i] < array2[j]) {
                System.out.print(array1[i] + " ");
                i++;
            }
            else if (array1[i] > array2[j]) {
                System.out.print(array2[j] + " ");
                j++;
            }
            else {
                System.out.print(array1[i] + " ");
                i++;
                j++;
            }
        }

        while (i < array1.length) {
            System.out.print(array1[i] + " ");
            i++;
        }

        while (j < array2.length) {
            System.out.print(array2[j] + " ");
            j++;
        }

  }    
}
