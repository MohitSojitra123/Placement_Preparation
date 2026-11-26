public class Rotate_Matrix_90Degree {
    public static void main(String[] args) {
        
        int arr[][] = {
                {0, 1, 2}, 
                {3, 4, 5}, 
                {6, 7, 8}
        };

        int n=arr.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }


        for(int i=0; i<n; i++){
            int start=0;
            int end=n-1;

            while(start<end){
                int Temp=arr[start][i];
                arr[start][i]=arr[end][i];
                arr[end][i]=Temp;
                start++;
                end--;
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}
