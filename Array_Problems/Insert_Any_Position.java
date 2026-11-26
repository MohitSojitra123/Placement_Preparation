import java.util.Scanner;

public class Insert_Any_Position {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int array[] = {10,20,30,40,50};

        System.out.print("Enter Element: ");
        int new_element = sc.nextInt();

        System.out.print("Enter Position: ");
        int position = sc.nextInt();

        int new_array[] = new int[array.length + 1];


        for(int i = 0; i < position; i++) {
            new_array[i] = array[i];
        }

        new_array[position] = new_element;

        for(int i = position; i < array.length; i++) {
            new_array[i + 1] = array[i];
        }


        System.out.println("\nUpdated Array:");

        for(int i = 0; i < new_array.length; i++) {

            System.out.print(new_array[i] + " ");
        }
    }
}