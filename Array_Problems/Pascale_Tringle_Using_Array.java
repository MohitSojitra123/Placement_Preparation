public class Pascale_Tringle_Using_Array {
    public static void main(String[] args) {

        int n = 5;

        int array[][] = new int[n][];

        // Create row sizes
        for(int i = 0; i < n; i++) {
            array[i] = new int[i + 1];
        }

        // First and last element = 1
        for(int i = 0; i < n; i++) {
            array[i][0] = 1;
            array[i][i] = 1;
        }

        // Middle values
        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
                array[i][j] = array[i-1][j] + array[i-1][j-1];
            }
        }

        // Print
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}