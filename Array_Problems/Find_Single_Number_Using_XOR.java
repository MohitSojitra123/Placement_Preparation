public class Find_Single_Number_Using_XOR {
    public static void main(String[] args) {

          int array[]={3,3,7,7,10,11,11};
        
          int result=0;

          for(int i : array){
            result=result^i;
          }

          System.out.println(result);

    }
}
