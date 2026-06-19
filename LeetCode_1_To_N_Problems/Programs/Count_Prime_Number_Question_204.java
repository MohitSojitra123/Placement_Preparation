public class Count_Prime_Number_Question_204 {

    public static void main(String[] args) {

        int n = 20;

        boolean[] prime = new boolean[n];

        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {

            if (prime[i]) {

                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        System.out.print("Prime Numbers: ");

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println("\nCount = " + count);
    }
}