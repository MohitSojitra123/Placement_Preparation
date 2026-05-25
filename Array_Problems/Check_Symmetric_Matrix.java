// Check Symmetric Matrix


import java.util.Scanner;

public class Check_Symmetric_Matrix {
   public static void main(String[] args) {


        int array[][]={
            {1,2,3},
            {2,5,6},
            {3,6,9}
        };

        // int array[][]={
        //     {1,2,3},
        //     {2,5,6},
        //     {1,6,9}
        // };

        boolean flag=true;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(array[i][j]!=array[j][i]){
                    flag=false;
                    break;
                }
            }
        }

        if(flag){
            System.out.println("Matrix Is Symmetric : ");
        }else{
            System.out.println("Matrix Is Not Symmetric : ");            
        }

   }    
}
