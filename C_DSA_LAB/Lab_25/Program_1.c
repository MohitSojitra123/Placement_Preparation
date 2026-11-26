// Read n numbers in an array from user and sort them in ascending order using 
// Quick Sort algorithm and print sorted array.


#include <stdio.h>


void quick_sort(int K[], int LB, int UB) {
    int I, J, KEY, FLAG, temp;

    if (LB < UB) {
        I = LB;
        J = UB + 1;
        KEY = K[LB];     
        FLAG = 1;

        while (FLAG) {
            do {
                I = I + 1;
            } while (I <= UB && K[I] < KEY);
     
            do {
                J = J - 1;
            } while (K[J] > KEY);

     
            if (I < J) {
                temp = K[I];
                K[I] = K[J];
                K[J] = temp;
            } else {
                FLAG = 0;
            }
        }

        temp = K[LB];
        K[LB] = K[J];
        K[J] = temp;

        quick_sort(K, LB, J - 1);
        quick_sort(K, J + 1, UB);
    }
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int K[n];

    for (int i = 0; i < n; i++) {
        printf("Enter element: ");
        scanf("%d", &K[i]);
    }
 
    quick_sort(K, 0, n - 1);

    printf("\nSorted Array (Ascending): ");
    for (int i = 0; i < n; i++) {
        printf("%d ", K[i]);
    }
    return 0;
}
