public class Single_Number_XOR_Question_136 {

    public static void main(String[] args) {

        int array[] = {4, 1, 2, 1, 2};

        int result = 0;

        for (int num : array) {
            result = result ^ num;
        }

        System.out.println("Single Number = " + result);
    }
}