import java.util.Scanner;

public class Convert_String_Into_Lower_Case {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String : ");
        String str=sc.nextLine();

        char str_char[]=str.toCharArray();

        for(int i=0; i<str_char.length; i++){
              if(str_char[i]>='A' && str_char[i]<='Z'){
                     str_char[i]=(char)(str_char[i]+32);
              }
        }

        System.out.println(str_char);
          

    }
}
