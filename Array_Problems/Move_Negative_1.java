import java.util.Arrays;

public class Move_Negative_1 {
    public static void main(String[] args) {

        int array[] = {1,-1,2,-2,3,-3,4,-4,5,-5,6,-6,7,-7,8,-8,9,-9,10};

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            while (left < right && array[left] >= 0)
                left++;

            while (left < right && array[right] < 0)
                right--;

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}