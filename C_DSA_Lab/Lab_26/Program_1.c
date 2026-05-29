// 1. Read n numbers in an array from user and sort them in ascending order using 
// Merge Sort algorithm and print sorted array. 

#include <stdio.h>


void merge(int arr[], int LB, int mid, int UB) {
    int i = LB;
    int j = mid + 1;
    int k = LB;

    int temp[100];

    while (i <= mid && j <= UB) {
        if (arr[i] < arr[j]) {
            temp[k] = arr[i];
            i++;
        } else {
            temp[k] = arr[j];
            j++;
        }
        k++;
    }

    while (i <= mid) {
        temp[k] = arr[i];
        i++;
        k++;
    }

    while (j <= UB) {
        temp[k] = arr[j];
        j++;
        k++;
    }


    for (int x = LB; x <= UB; x++) {
        arr[x] = temp[x];
    }
}


void merge_sort(int arr[], int LB, int UB) {
    if (LB < UB) {
        int mid = (LB + UB) / 2;
        merge_sort(arr, LB, mid);      
        merge_sort(arr, mid + 1, UB); 
        merge(arr, LB, mid, UB);  
    }
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];


    for (int i = 0; i < n; i++) {
        printf("Enter element: ");
        scanf("%d", &arr[i]);
    }


    merge_sort(arr, 0, n - 1);

    printf("\nSorted Array (Ascending): ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}