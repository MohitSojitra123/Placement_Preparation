// Write a Function that returns either 1 or 0 based on following condition if the array is in ascending order 
// and occurrence of that number at least 3 then it should return 1 otherwise it should return 0.  
// e.g. if A=[1,1,1,2,2] it should return 0, if A= [1,1,1,3,3,3,3] it should return 1. 

public class Question_38 {

    static int checkArray(int arr[]) {

        int count = 1;
        int numbersWithAtLeast3 = 0;

        for (int i = 1; i < arr.length; i++) {

     
            if (arr[i] < arr[i - 1]) {
                return 0;
            }

          
            else if (arr[i] == arr[i - 1]) {
                count++;
            }

         
            else {
                if (count >= 3) {
                    numbersWithAtLeast3++;
                }
                count = 1;
            }
        }


        if (count >= 3) {
            numbersWithAtLeast3++;
        }

        return (numbersWithAtLeast3 >= 1) ? 1 : 0;
    }

    public static void main(String[] args) {

        int A1[] = {1, 1, 1,1};
        int A2[] = {1, 1, 1, 3, 3, 3, 3};

        System.out.println(checkArray(A1)); // 0
        System.out.println(checkArray(A2)); // 1
    }
}