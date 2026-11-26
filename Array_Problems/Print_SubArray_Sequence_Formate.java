import java.util.Scanner;

public class Print_SubArray_Sequence_Formate {
    public static void main(String[] args) {
        
        int array[]={10,20,30,40,50,60,70};

        for(int i=0; i<array.length; i++){
            for(int j=i;j<array.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(array[k]+" ");
                }
                System.out.println("----------------");
            }
        }

    }
}
