import java.util.Scanner;

class Ugly_Number{
       public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

             System.out.println("Enter Number : ");  
             int num=sc.nextInt();

             boolean IsUgly=true;

             for(int i=2; i<=num; i++){
                   while (num%i==0) {
                          if(i==3 || i==2 || i==5){
                              num/=i;
                        }else{
                            IsUgly=false;           
                            break;
                          }
                   }
             }

             if(IsUgly){
                 System.out.println("Number Is Ugly : ");
             }else{
                System.out.println("Number Is Not Ugly : ");
             }

       }
}