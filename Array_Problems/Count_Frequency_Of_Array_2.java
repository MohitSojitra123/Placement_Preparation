import java.util.HashMap;

public class Count_Frequency_Of_Array_2 {
    public static void main(String[] args) {

        int array[]={10,20,30,40,50,50,30,10,30,50,10,10};

       
        boolean check[]=new boolean[array.length];

        for(int i=0; i<array.length; i++){

            int count=1;

            if(check[i]==true){
                    continue;
            }else{
                  for(int j=i+1; j<array.length; j++){
                       if(array[i]==array[j]){
                             count++;
                             check[j]=true;
                       }
                }
            }

            System.out.println(array[i]+" -> "+count);

        }


    }
}
