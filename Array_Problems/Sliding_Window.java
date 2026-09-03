public class Sliding_Window {
    public static void main(String[] args) {
        
           int array[]={1,12,-5,-6,50,3};
        //    int k=2;
           int k=3;

           for(int i=0; i<array.length; i++){
        

              for(int j=i; j<i+k && i+k <= array.length; j++){
                    System.out.print(array[j]+" ");
              }
            System.out.println();


           }


    }
}
