class Rotate_Matrix_90{

    public static void main(String[] args) {
        
        
        int array[][]={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        
        // j = 0 --> j < i  Only Diagonal Element Reverse      
        // full j=0; ---> j < n Transpose than Tanspose === Original Array 


        int n = array.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        

        for(int i=0; i<n; i++){

            int start=0;
            int end=n-1;

            while (start<end) {
                int temp=array[i][start];
                array[i][start]=array[i][end];
                array[i][end]=temp;
                start++;
                end--;
            }
        }

        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        
    }   
    }