import java.util.Arrays;

class Check_Two_Arrays_Equal{
    public static void main(String[] args) {
        
          int array1[]={10,20,30,40,50,60};
          int array2[]={10,20,30,40,50,60};

        //   if(Arrays.equals(array1, array2)){
        //     System.out.println("Both Array Is Same : ");
        //   }else{
        //     System.out.println("Both Array Is Not Same : ");
        //   }

        boolean isbothsame=true;


        if(array1.length==array2.length){
           
              for(int i=0; i<array1.length; i++){
                  if(array1[i]!=array2[i]){
                      isbothsame=false;
                      break;
                  }
              }


              if(isbothsame){
                System.out.println("Both Array  Is Same : ");
              }else{
                System.out.println("Both Array Is Not Same : ");
              }
            
        }else{
            System.out.println("Both Array is Not Same : ");
            return;
        }


    }
}