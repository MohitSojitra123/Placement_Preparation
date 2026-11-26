public class Check_If_Exist_Question_1346 {

    public static void main(String[] args) {

        // Static Array
        int arr[] = {0, -2, 2};

        boolean result = false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i != j && arr[i] == (arr[j] * 2)) {
                    result = true;
                    break;
                }
            }

            if (result) {
                break;
            }
        }

        System.out.println("Result : " + result);
    }
}