import java.util.Scanner;

public class Remove_Duplicate_Character_From_String {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.nextLine();

        char str_arr[] = str.toCharArray();

        int size = str_arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (str_arr[i] == str_arr[j]) {

                    for (int k = j; k < size - 1; k++) {
                        str_arr[k] = str_arr[k + 1];
                    }

                    size--;
                    j--;
                }
            }
        }

        System.out.println("Remove Duplicate Character in String : ");

        for (int i = 0; i < size; i++) {
            System.out.print(str_arr[i]);
        }
    }
}