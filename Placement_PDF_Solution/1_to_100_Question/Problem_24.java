// WAP to delete an element from array specified by user. if element is not found print a 
// message “Element is not found” (do not take a new array). 

import java.util.Arrays;
import java.util.Scanner;

public class Problem_24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


          System.out.println("Enter Array size : ");
           int array_size=sc.nextInt();


           int array[]=new int[array_size];

           for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
           }

           System.out.println(Arrays.toString(array));

           System.out.println("Enter Element To Delete in Array : ");
           int delete_ele=sc.nextInt();

           boolean flag=false;

           for(int i=0; i<array_size; i++){
            if(array[i]==delete_ele){
                for(int k=i; k<array_size-1; k++){
                    array[k]=array[k+1];
                }
                array_size--;
                flag=true;
                break;
            }
           }

           if(!flag){
            System.out.println("Element Not Present : ");
            return;
           }

           for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
           }






    }
}
