import java.util.HashSet;

public class Count_Consicutive_Numbers {
    public static void main(String[] args) {
        
        HashSet<Integer> hs=new HashSet<>();


        int arr[] = {91, 94, 93, 1000, 89,5, 92,90, 78};

        for(int i=0; i<arr.length; i++){
              hs.add(arr[i]);
        }


        int max_count=1;
        int count=1;
        int start_point=1;

        for(int i=0; i<arr.length; i++){
            
            int current=arr[i]+1;

             while(hs.contains(current)){
                    count++;
                    current+=1;
             }
             
            
                if(count>max_count){
                      max_count=count;
                     start_point=arr[i];
                }
                    
                    count=1;

        }

        System.out.println(max_count);
        System.out.println(start_point);


    }
}
