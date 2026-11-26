import java.util.Scanner;

public class String_Group {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          
          String str;

          System.out.println("Enter String : ");
          str=sc.nextLine();

          System.out.println("Enter Group Number : ");
          int group_number=sc.nextInt();

          System.out.println("Str : "+str);

          for(int i=0; i<str.length(); i+=group_number){
               if(i+group_number<str.length()){
                    System.out.println(str.substring(i, i+group_number));  
               }else{
                    System.out.println(str.substring(i));
               }
          }




    }
}
