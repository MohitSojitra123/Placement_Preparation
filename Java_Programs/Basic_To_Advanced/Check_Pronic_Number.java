import java.util.Scanner;

class Chack_Pronic_Number{
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         int user_num;

         System.out.println("Enter Number : ");
         user_num=sc.nextInt();

         boolean flag=false;

         for(int i=0; i<user_num; i++){
                if(i*(i+1)==user_num){
                       flag=true;
                       break;
                }
         }

         if(flag){
            System.out.println("Number Is Pronic : ");
         }else{
            System.out.println("Number Is Not Pronic : ");
         }

    }
}