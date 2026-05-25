import java.util.Scanner;

public class Remove_All_White_Space {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str;

        System.out.println("Enter String : ");
        str=sc.nextLine();

        str=str.replaceAll("\\s", "");
      
        System.out.println("Remove Withspace : ");
        System.out.println(str);

    }
}
