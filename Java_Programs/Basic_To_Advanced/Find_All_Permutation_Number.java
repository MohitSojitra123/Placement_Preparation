import java.util.HashSet;

public class Find_All_Permutation_Number {

    public static void main(String[] args) {
        

          int array[]={1,2,3,4};
          int num=0;

          HashSet<Integer> hs=new HashSet<>();

          for(int i=0; i<array.length; i++){
            
            for(int j=0; j<array.length; j++){

                for(int k=0; k<array.length; k++){
                    
                    if(i==j || i==k || j==k){
                           continue;
                    }else{   
                        num=array[i]*100+array[j]*10+array[k];
                    }
                    hs.add(num);
                }

            }

          }

          System.out.println(hs);
          System.out.println(hs.size());

    }

    
}