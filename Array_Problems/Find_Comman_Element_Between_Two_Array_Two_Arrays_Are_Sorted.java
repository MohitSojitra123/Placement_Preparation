public class Find_Comman_Element_Between_Two_Array_Two_Arrays_Are_Sorted {
    public static void main(String[] args) {
        
int array1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,33,44};

        int array2[] = {1,5,10,11,15,20,33};

        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {

            if (array1[i] == array2[j]) {
                System.out.println(array1[i]);
                i++;
                j++;
            }
            else if (array1[i] < array2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

    }
}
