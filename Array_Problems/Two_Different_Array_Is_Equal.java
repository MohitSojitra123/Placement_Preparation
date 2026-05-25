import java.util.Arrays;
import java.util.Scanner;

public class Two_Different_Array_Is_Equal {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int array1[]={10,20,30,80,70,60,50,40};
          int array2[]={10,20,30,80,70,60,50,40};

        //   if(Arrays.equals(array1, array1)){
        //     System.out.println("Array 1 Or Array 2 Is Equal : ");
        //   }else{
        //     System.out.println("Array 1 Or Array 2 Is Not Equal : ");
        //   }

        boolean isEqual=true;

           if(array1.length!=array2.length){
              System.out.println("Array 1 Or Array 2 Is Not Equal : ");
              return;
           }


           for(int i=0; i<array1.length; i++){
            if(array1[i]!=array2[i]){
                  isEqual=false;
                  break;
            }
           }

           if(isEqual){
            System.out.println("Arrayy 1 Or Array 2 Is Equal : ");
        }else{
               System.out.println("Arrayy 1 Or Array 2 Is Equal : ");
           }

    }
}
