import java.util.Scanner;

public class Reverse_String_Each_Word {
    public static void main(String[] args) {
         
        String str="I am MCA Student In Darshan Univercity ";

        String str_arr[]=str.split("\\s");

        StringBuilder sb=new StringBuilder("");

        String str_rev="";

        for(int i=0; i<str_arr.length; i++){
            
            sb.delete(0, sb.length());
            sb.append(str_arr[i]+" ");
            str_rev=str_rev + sb.reverse();
        }

        System.out.println("\n\n");
        System.out.println(str_rev);
        System.out.println("\n\n");

    }
}
