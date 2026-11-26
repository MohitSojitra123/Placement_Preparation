class Find_Single_Element_In_Sorted_Array{
    public static void main(String[] args) {
        
        int array[]={1,1,2,2,3,3,4,8,8};

        int count=1;

        for(int i=0; i<array.length-1; i++){
            
            count=1;

            if(array[i]==array[i+1]){
                  i++;
            }else{
                if(count!=2){
                     System.out.println("Single Element Is : "+array[i]);
                    break;
                }
            }

        }

    }
}