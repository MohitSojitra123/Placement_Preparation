public class Lexicographical_Smallest_String {

    public static void main(String[] args) {

        String arr[] = {"apple", "banana", "orange", "grape", "watermelon"};

        String smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i].compareTo(smallest) < 0) {

                smallest = arr[i];
            }
        }

        System.out.println("Lexicographically Smallest String : " + smallest);
    }
}