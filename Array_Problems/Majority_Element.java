public class Majority_Element {
   public static void main(String[] args) {
    
        int array[]={1,2,3,2,1,3,3,2,1,3,1,3,3,2,1,5,6,1,9,1};


        int Majority_Element=array[0];
        int count=0;

        for(int i=0; i<array.length; i++){
            if(array[i]==Majority_Element){
                count++;
            }else if(count<0){
                Majority_Element=array[i];
                count=0;
            }else{
                count--;
            }
        }

        System.out.println("Majority Element : "+Majority_Element);

   }    
}