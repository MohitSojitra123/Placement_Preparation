public class First_Non_Repeating_Element {
    public static void main(String[] args) {
         
         int array[]={13,15,72,18,61,13,15,72,61};

        boolean IsRepeated=false;

        for(int i=0; i<array.length; i++){
            IsRepeated=false;

             if(array[i]==-1){
                  continue;
             }else{
                 for(int j=i+1; j<array.length; j++){
                     if(array[i]==array[j]){
                         IsRepeated=true;
                         array[j]=-1;
                        }
                    }
                    if(!IsRepeated){
                        System.out.println("First Non Repeated Element Is : "+array[i]);
                    }
                }
        }

    }
}
