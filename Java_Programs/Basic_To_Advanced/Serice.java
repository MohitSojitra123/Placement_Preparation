// 1,3,6,10,15,21,....(Up To N..)

import java.util.Scanner;

public class Serice {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Print N Term Series...");
        int user=sc.nextInt();

        int count=2;
        int last_value=1;

        System.out.println("1 ");

        for(int i=1; i<=user; i++){
            System.out.print(count+last_value+" ");
             last_value=count+last_value;
             count++;
        }

        
    }
}

