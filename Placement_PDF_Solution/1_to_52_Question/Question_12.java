// 1 
// 1 * 1 
// 1 * 3 * 1 
// 1 * 3 * 5 * 3 * 1  

import java.util.Scanner;

public class Question_12 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();

        System.out.println();
        System.out.println();

          int current=0;
          int counter=1;
          int last=4;

           for(int i=1; i<=n; i++){
 
              last=4;
             
            if(i<=3){

                for(int j=1; j<=((i*2)-1); j++){
                    if(j==1 || j==((i*2)-1)){
                        System.out.print(1);
                    }else if(j%2!=0){
                          System.out.print(j);
                      }else{
                          System.out.print("*");
                        }  
                    }

            }else{
                
                for(int j=1; j<=((i*2)+counter);j++){
                     if(j==1 || j==((i*2)+counter)){
                        System.out.print(1);
                     }else if(j%2!=0){
                          if(j<=((i*2)+counter+1)/2){
                              System.out.print(j);
                          }else{ 
                              System.out.print( j-last);
                              last+=4;
                          }
                     }
                     else{
                        System.out.print("*");
                     }
                }
                counter+=2;
            }
            System.out.println();
           }

           
        System.out.println();
        System.out.println();

    }
}
