#include<stdio.h>

// // Given an integer n, the task is to find the first n rows of Pascal’s triangle.
// // Input : N = 5
// // Output:
// //         1
// //       1   1
// //     1  2  1
// //    1 3 3 1
// //   1 4 6 4 1

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=0; i<n; i++){
        int number = 1;

        for(int space=0; space<n-i-1; space++){
            printf(" ");
        }

        for(int j=0; j<=i; j++){

            printf("%d ", number);

            number = number * (i-j) / (j+1);
        }

        printf("\n");
    }

    return 0;
}