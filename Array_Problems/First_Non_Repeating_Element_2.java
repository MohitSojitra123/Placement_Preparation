public class First_Non_Repeating_Element_2 {

    public static void main(String[] args) {

        int array[] = {10, 20, 30, 10, 20, 40, 50, 40};

        for (int i = 0; i < array.length; i++) {

            int count = 0;

            for (int j = 0; j < array.length; j++) {

                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("First Non-Repeating Element = " + array[i]);
                break;
            }
        }
    }
}