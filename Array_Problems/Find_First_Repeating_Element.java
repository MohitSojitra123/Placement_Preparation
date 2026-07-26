import java.util.HashSet;

public class Find_First_Repeating_Element {
    public static void main(String[] args) {
        
          int array[]={1,2,3,4,5,6,7,8,4};

  
          HashSet<Integer> hs=new HashSet<>();

          for(int i=0; i<array.length; i++){
                if(hs.contains(array[i])){
                    System.out.println("First Repeatin Element : "+array[i]);
                    break;
                }else{
                    hs.add(array[i]);
                }
          }

          

    }
}
