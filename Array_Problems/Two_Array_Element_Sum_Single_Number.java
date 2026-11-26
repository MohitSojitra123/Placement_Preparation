import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two_Array_Element_Sum_Single_Number {
    public static void main(String[] args) {
          
        List<Integer> li=new ArrayList<>();

        int array1[]={1,5,7,3};
        int array2[]={1,7,3};


        StringBuilder arr1=new StringBuilder();
        StringBuilder arr2=new StringBuilder();


        for(int i=0; i<array1.length; i++){
            arr1.append(array1[i]);
        }

        
        for(int i=0; i<array2.length; i++){
            arr2.append(array2[i]);
        }

        int num1=Integer.parseInt(arr1.toString());
        int num2=Integer.parseInt(arr2.toString());

        System.out.println(num1+num2);

        int Final_Sum=num1+num2;

        while (Final_Sum!=0){
               li.addFirst(Final_Sum%10);
               Final_Sum/=10;
        }

        System.out.println(li);

    }
}
