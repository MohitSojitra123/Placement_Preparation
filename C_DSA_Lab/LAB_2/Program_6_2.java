import java.util.HashSet;

class Program_6_2{
    public static void main(String[] args){
        
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        HashSet<Integer> set=new HashSet<>();

        for(int i=0; i<array1.length; i++){
              set.add(array1[i]);
        }


        System.out.println("Duplicate Element : ");

        for(int j=0; j<array2.length; j++){
              if(set.contains(array2[j])){
                System.out.println(array2[j]);
              }
        }

    }
}