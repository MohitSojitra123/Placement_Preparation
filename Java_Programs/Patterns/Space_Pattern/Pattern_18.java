import java.util.Scanner;

class Pattern_18{
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);

       System.out.println("Enter Any Number To Print The Patter....");
       int User=sc.nextInt();

       int count=1;
       Character ch='A';
       
       System.out.println("--------------------------------");

       for(int i=1; i<=User; i++){
        
        for(int space=User; space>i; space--){
            System.out.print(" ");
        }

        for(int j=1; j<=i; j++){
            if(i%2!=0){
               System.out.print(ch+" ");
               ch++;  
            }
            else{
                 System.out.print(count+" ");
                count++;
            }
        }
       
        System.out.println();
       }


       System.out.println("--------------------------------");
    }
}