public class Extra_Program_2 {
      public static void main(String[] args) {
        
           int array[]={10,20,30,40,50,60,70,80,90,100};

            int max1=array[0];
            int max2=0;

           for(int i=0; i<array.length; i++){
                if(array[i] > max1){
                    max1=array[i];
                }
           }

           System.out.println("Max 1 => "+max1);

           for(int i=0; i<array.length; i++){
                if(array[i] == max1){
                    continue;
                }else if(array[i] > max2){
                         max2=array[i];
                }
           }

           System.out.println("Max 2 => "+max2);

      }
}


// int max1 = Integer.MIN_VALUE;
//         int max2 = Integer.MIN_VALUE;

//         for (int num : array) {
//             if (num > max1) {
//                 max2 = max1; // old max1 becomes max2
//                 max1 = num;
//             } else if (num > max2 && num != max1) {
//                 max2 = num;
//             }
//         }
