import java.util.Scanner;

public class Rotate_Array {


    static void Reverse(int arr[], int start, int end){

        while(start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array Size : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        for(int i=0; i<size; i++){

            System.out.print("Enter Element : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K Position : ");
        int k = sc.nextInt();

        // handle large k
        k = k % size;

        // Step 1
        Reverse(arr, 0, size - 1);

        // Step 2
        Reverse(arr, 0, k - 1);

        // Step 3
        Reverse(arr, k, size - 1);

        System.out.println("Rotated Array : ");

        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }
    }
}