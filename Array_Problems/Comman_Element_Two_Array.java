public class Comman_Element_Two_Array {
      public static void main(String[] args) {
        
           int array1[]={10,20,30,40,50,60};
           int array2[]={5,10,15,20,25,30,35,40,45,50,55,60};

           System.out.println("Comman Element : ");

           for(int i=0; i<array1.length; i++){
             for(int j=0; j<array2.length; j++){
                if(array1[i]==array2[j]){
                     System.out.println(array1[i]);   
                    break;
                }
             }
           }

      }
}
