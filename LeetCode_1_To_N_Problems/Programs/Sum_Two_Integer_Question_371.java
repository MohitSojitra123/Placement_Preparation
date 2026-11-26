public class Sum_Two_Integer_Question_371{

    public static void main(String[] args) {

        int a = 2;
        int b = 3;

        int result = getSum(a, b);

        System.out.println("Sum = " + result);
    }


    public static int getSum(int a, int b) {

        while (b != 0) {

            int carry = (a & b) << 1;

            a = a ^ b;

            b = carry;
        }

        return a;
    }
}