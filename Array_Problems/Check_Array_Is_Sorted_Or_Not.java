import java.util.Scanner;

public class Check_Array_Is_Sorted_Or_Not {
    public static void main(String[] args) {
         
        int array[]={10,20,30,40,50,60,70,5};

        boolean IsSorted=true;

        for(int i=0; i<array.length-1; i++){
            if(array[i]>array[i+1]){
                  IsSorted=false;
                  break;
            }
        }

        if(IsSorted){
            System.out.println("Array Is Sorted : ");
        }else{
            System.out.println("Array Is Not Sorted :");
        }

    }
}
