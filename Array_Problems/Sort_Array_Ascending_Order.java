import java.util.Arrays;

public class Sort_Array_Ascending_Order {
    public static void main(String[] args) {
        
         int array[]={4,8,1,5,2,10,9,7,2,4,3};

         System.out.println("Befor : "+Arrays.toString(array));
         
         for(int i=0; i<array.length-1; i++){
             for(int j=0; j<array.length-1-i; j++){
                 if(array[j]>array[j+1]){
                     int temp=array[j];
                     array[j]=array[j+1];
                     array[j+1]=temp;
                    }
                }
            }

            
            System.out.println("Befor : "+Arrays.toString(array));


    }
}
