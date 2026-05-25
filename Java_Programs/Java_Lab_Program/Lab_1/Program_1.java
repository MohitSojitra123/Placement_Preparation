// WAP to find a Factor of a given number.[

import java.util.Scanner;

class Program_1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  

        System.out.println("Enter Any Number To Finad Factor => ");
        int user=sc.nextInt();

 
         for(int i=1; i<=user; i++){
            if(user%i==0){
                System.out.println(i);
            }
         }

       
    }
}