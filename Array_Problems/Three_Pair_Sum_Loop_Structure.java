public class Three_Pair_Sum_Loop_Structure {
    public static void main(String[] args) {
        
          int array[]={87,34,79,25,73,29,24,61,68,38,29,1};


          int target=91;


          for(int i=0; i<array.length-2; i++){
            for(int j=i+1; j<array.length-1; j++){
                for(int k=j+1; k<array.length; k++){
                    System.out.println(array[i]+" -> "+array[j]+" -> "+array[k]);
                }
            }
            System.out.println("\n--------------------\n");
          }

    }
}
