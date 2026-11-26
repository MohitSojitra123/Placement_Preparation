import java.util.Arrays;

class arraylist{
      int arr[]=new int[5];

       int size=0;
       int current_index=0;

      void addd(int val){
       if(size==arr.length){
          int brr[]=Arrays.copyOf(arr, arr.length*2);
          arr=brr;
       }

       arr[current_index]=val;
       size++;
       current_index++; 
      }


      void display(){
        for(int i=0; i<current_index; i++){
            System.out.print(arr[i]+" ");
        }
      }

}

class Create_ArrayList{
    public static void main(String[] args){
        
        arraylist ar=new arraylist();

        ar.addd(10);
        ar.addd(20);
        ar.addd(30);
        ar.addd(40);
        ar.addd(50);  // Full First arr 
        ar.addd(60);   // Reintialize 
        ar.addd(70);

        ar.display();
      
        
    }
}