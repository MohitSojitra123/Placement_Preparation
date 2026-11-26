import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

         String str;

        System.out.println("Enter String : ");
        str=sc.nextLine();   


        char str_arr[]=str.toCharArray();

        int Last_index=str_arr.length-1;
        int First_Index=0;

        while (First_Index<=Last_index) {
                char temp=str_arr[First_Index];
                str_arr[First_Index]=str_arr[Last_index];
                str_arr[Last_index]=temp;

                First_Index++;
                Last_index--;
        }

        System.out.println("\n---------------\n");
        
          for(int i=0; i<str_arr.length; i++){
            System.out.print(str_arr[i]+"-");
          }

          System.out.println("\n---------------\n");

          String reverse_str=new String(str_arr);

          System.out.println(reverse_str);

    
    }
}
