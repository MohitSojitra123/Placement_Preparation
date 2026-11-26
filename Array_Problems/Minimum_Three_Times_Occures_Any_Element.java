public class Minimum_Three_Times_Occures_Any_Element {
    public static void main(String[] args) {
        
            int array[]={1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,5,5,5};

            int count=1;
            boolean isvalid=true;

            for(int i=1; i<array.length; i++){
                  if(array[i-1]==array[i]){
                       count++;
                  }else{
                    if(count>=3){
                          count=1;
                    }else{
                        isvalid=false;
                        break;
                    }
                  }
            }

            if(count<3){
                  isvalid=false;
            }

            if(isvalid){
                System.out.println("Array All Element Occured In Minimum Three Times ");
            }else{
                System.out.println("Array All Element Not  Occured In Minimum Three Times ");
            }

    }
}
