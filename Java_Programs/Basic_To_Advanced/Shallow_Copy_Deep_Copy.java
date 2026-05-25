import java.util.Arrays;

class Shallow_Copy_Deep_Copy{
    public static void main(String[] args) {
        
          int array1[]={10,20,30}; 
          int array2[]=array1;  // shallow copy 

          System.out.println(Arrays.toString(array1));
          System.out.println(Arrays.toString(array2));
          
          array1[1]=2000;
          
          System.out.println(Arrays.toString(array1));
          System.out.println(Arrays.toString(array2));
    

          int array3[]={40,50,60};
           
          int array4[]=Arrays.copyOf(array3, array3.length);

          System.out.println(Arrays.toString(array3));
          System.out.println(Arrays.toString(array4));

          array3[1]=4000;

        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));



    
    }
}