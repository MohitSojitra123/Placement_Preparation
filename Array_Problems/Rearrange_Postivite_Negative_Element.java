// Rearrange array in alternating positive and negative numbers.

// Example 1
// Input: [1, 2, 3, -4, -1, 4]
// Positives: [1, 2, 3, 4]
// Negatives: [-4, -1]
// Alternating merge: [-4, 1, -1, 2, 3, 4]
// Output:
// [-4, 1, -1, 2, 3, 4]

// Example 2
// Input: [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
// Positives: [5, 2, 4, 7, 1, 8, 0]
// Negatives: [-5, -2, -8]
// Alternating merge: [-5, 5, -2, 2, -8, 4, 7, 1, 8, 0]
// Output:
// [-5, 5, -2, 2, -8, 4, 7, 1, 8, 0]

// Example 3
// Input: [3, -3, 3, -3, 3]
// Positives: [3, 3, 3]
// Negatives: [-3, -3]
// Alternating merge: [-3, 3, -3, 3, 3]
// Output:
// [-3, 3, -3, 3, 3]

import java.util.ArrayList;

public class Rearrange_Postivite_Negative_Element {

    public static void main(String[] args) {

        int array[] = {1, 2, 3, -4, -1, 4};

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();


        for(int i = 0; i < array.length; i++) {

            if(array[i] >= 0) {

                positive.add(array[i]);

            } else {

                negative.add(array[i]);
            }
        }

        int result[] = new int[array.length];

        int i = 0;
        int p = 0;
        int n = 0;


        while(p < positive.size() && n < negative.size()) {

            result[i++] = negative.get(n++);
            result[i++] = positive.get(p++);
        }

    
        while(p < positive.size()) {

            result[i++] = positive.get(p++);
        }


        while(n < negative.size()) {

            result[i++] = negative.get(n++);
        }


        System.out.println("Rearranged Array:");

        for(int k = 0; k < result.length; k++) {

            System.out.print(result[k] + " ");
        }
    }
}