import java.util.Scanner;

public class Find_Longest_Word_In_String {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          
          int array_size;

          System.out.println("Enter Array Size : ");
          array_size=sc.nextInt();

          sc.nextLine();

          String str[]=new String[array_size];

          for(int i=0; i<array_size; i++){
            System.out.println("Enter String :  ");
            str[i]=sc.nextLine();
          }

          System.out.println("\n---------------------\n");
           for(int i=0; i<array_size; i++){
            System.out.println(str[i]);
           }
          System.out.println("\n---------------------\n");

          String Longest_Word=str[0];

          for(int i=1; i<array_size; i++){
            if(str[i].length()>Longest_Word.length()){
                    Longest_Word=str[i]; 
            }
          }

          System.out.println("\n Longest Word : "+Longest_Word);
          System.out.println("\n Longest Word Length : "+Longest_Word.length());

    }
}
