public class Transpose_Matrix_Row_Col {
    public static void main(String[] args) {
        
          int array[][]={
            {1,2,3},
            {4,5,6}
          };

          int row=array.length;
          int col=array[0].length;

          int new_array[][]=new int[col][row];

          for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                new_array[j][i]=array[i][j];
            }
          }

          for(int i=0; i<new_array.length; i++){
            for(int j=0; j<new_array[0].length; j++){
                System.out.print(new_array[i][j]+" ");
            }
            System.out.println();
          }

    }
}
