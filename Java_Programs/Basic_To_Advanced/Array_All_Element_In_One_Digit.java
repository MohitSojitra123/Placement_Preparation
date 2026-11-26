import java.util.ArrayList;

public class Array_All_Element_In_One_Digit {
    public static void main(String[] args) {
           int array[]={3,6,0,0,4};

           int Total_Digit=0;


           for(int i=0; i<array.length; i++){
                    Total_Digit=(Total_Digit*10)+array[i];
           }

           System.out.println("Array In One Digit : "+Total_Digit);


    }   
}
