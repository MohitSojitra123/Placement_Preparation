public class Transpose_Same_Array {
  public static void main(String[] args) {
    
      int array[][]={
        {1,2,7,3},
        {4,5,2,8},
        {7,8,9,6},
        {5,1,4,2}
      };

      for(int i=0; i<array.length; i++){
        for(int j=0; j<array[i].length; j++){
            System.out.print(array[i][j]+" ");
        }
        System.out.println();
      }

      for(int i=0; i<array.length; i++){
        for(int j=0; j<i; j++){
             int temp=array[i][j];
             array[i][j]=array[j][i];
             array[j][i]=temp;
        }
      }

      System.out.println("\n\n");
      System.out.println("-----------------------");
      System.out.println("\n\n");

      for(int i=0; i<array.length; i++){
        for(int j=0; j<array[i].length; j++){
            System.out.print(array[i][j]+" ");
        }
        System.out.println();
      }

  }
}