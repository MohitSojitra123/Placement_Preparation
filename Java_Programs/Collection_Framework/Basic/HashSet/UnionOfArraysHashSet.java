package HashSet;
// Input:
// arr1 = [1,1,2,2]
// arr2 = [2,3,3]

// Output:
// [1,2,3]


import java.util.HashSet;

public class UnionOfArraysHashSet {

    public static void main(String[] args) {

        int arr1[] = {1,2,3,4};
        int arr2[] = {3,4,5,6};

        HashSet<Integer> set = new HashSet<>();


        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {

            set.add(num);
        }

        System.out.println("Union of Arrays:");

        for (int num : set) {

            System.out.print(num + " ");
        }
    }
}
