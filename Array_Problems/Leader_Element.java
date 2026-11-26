public class Leader_Element {
    public static void main(String[] args) {
        
          int array[]={20,30,72,60,10,4,75,6,41,71,34,21,32};

          int Leader_Element=0;

          for(int i=array.length-1; i>=0; i--){
            if(array[i]>Leader_Element){
                Leader_Element=array[i];
            }
          }

          System.out.println("Leader Element : "+Leader_Element);

    }
}
