import java.util.Scanner;

public class Find_Longest_Word_In_Syntax {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter  Syntax ");
          String str=sc.nextLine();

          String str_arr[]=str.split("\\s");

          for(int i=0; i<str_arr.length; i++){
            System.out.println(str_arr[i]);
          }
         
          String Longest_Word=str_arr[0];

          for(int i=1; i<str_arr.length; i++){
                  if(str_arr[i].length()>Longest_Word.length()){
                      Longest_Word=str_arr[i];
                  }
          }

          System.out.println("Longest Word Is : "+Longest_Word);
          System.out.println("Longest Word Iength : "+Longest_Word.length());

    }
}
