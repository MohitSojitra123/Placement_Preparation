import java.util.Scanner;

public class Automorphic_Number {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        int n;

        System.out.println("Enter Number : ");
         n=sc.nextInt();

         int user_num=n;

         int user_number_length=0;

         while(n!=0){
               user_number_length++;
               n/=10;
         }

         int num_squre=user_num*user_num;

         String str=Integer.toString(num_squre);


         String Comparision_str=str.substring(str.length()-user_number_length,str.length());

         String User_num_String=Integer.toString(user_num);

         if(User_num_String.equals(Comparision_str)){
            System.out.println("Number Is Automorphic : ");
         }else{
            System.out.println("Number Is Not Automorphic : ");
         }


    }
}
