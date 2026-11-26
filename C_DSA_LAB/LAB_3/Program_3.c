// Write a program to find transpose of a square matrix. 

#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Row-Col Size : ");
    scanf("%d",&array_size);

    int array[array_size][array_size];

    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("Enter Array Element : ");
            scanf("%d",&array[i][j]);
        }
    }

    printf("\n------------------------\n");
    printf("Without Transpose matrix : ");
    printf("\n------------------------\n");


    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("%d",array[i][j]);
        }
        printf("\n");
    }

      printf("\n------------------------\n");
    printf("With Transpose matrix : ");
    printf("\n------------------------\n");

    
    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("%d",array[j][i]);
        }
        printf("\n");
    }


}