import java.util.*;

public class Find_Duplicate_Element_Using_Hashset{
    public static void main(String[] args) {

        int arr[] = {1,2,3,2,4,5,3};

        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){
            if(set.contains(num)){
                System.out.println("Duplicate: " + num);
            }else{
                set.add(num);
            }
        }
    }
} 
