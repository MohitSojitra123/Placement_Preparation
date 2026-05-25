#include<stdio.h>

// Write a program that prints the Fibonacci series up to a given number of terms using
// recursion.
// Input: n = 5
// Output: 0 1 1 2 3
// Input: N = 7
// Output: 0 1 1 2 3 5 8

#include<stdio.h>

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    int a = 0;
    int b = 1;
    int c;

    for(int i=0; i<n; i++){

        printf("%d ", a);

        c = a + b;
        a = b;
        b = c;
    }

    return 0;
}