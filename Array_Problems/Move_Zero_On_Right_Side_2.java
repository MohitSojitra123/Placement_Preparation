import java.util.Arrays;

class Move_Zero_On_Right_Side_2 {

    public static void main(String[] args) {

        int array[] = {1,3,0,6,0,2,5,0,0,1,4,0,5,3,0,6,5};

        System.out.println(Arrays.toString(array));

        int index = 0;

        for(int i = 0; i < array.length; i++) {

            if(array[i] != 0) {

                int temp = array[i];
                array[i] = 0;
                array[index] = temp;

                index++;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}