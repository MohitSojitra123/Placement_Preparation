import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Check_String_Is_Anagram_Or_Not {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter String  1 : ");
        String str1=sc.nextLine();

        System.out.println("Enter String 2 : ");
    String str2=sc.nextLine();

    System.out.println(str1);
    System.out.println(str2);

      char str1_arr[]=str1.toCharArray();
      char str2_arr[]=str2.toCharArray();
        
       Arrays.sort(str1_arr);
       Arrays.sort(str2_arr);

       if(Arrays.equals(str1_arr, str2_arr)){
        System.out.println("String Is Anagram : ");
       }else{
        System.out.println("String Is Not Anagram : ");
       }

    }
}
