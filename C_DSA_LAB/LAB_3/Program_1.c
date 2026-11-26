// Read two 2x2 matrices and perform addition of matrices into third matrix and
// print it.

#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array1[array_size][array_size];
    int array2[array_size][array_size];
    int sum[array_size][array_size];

    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
           printf("Enter Array 1 Element  : %d ",(j+1));
            scanf("%d",&array1[i][j]);
        }
    }

    printf("\n-------------------\n");
    
    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("Enter Array 2 Element  : %d ",(j+1));
            scanf("%d",&array2[i][j]);
            sum[i][j]=array1[i][j]+array2[i][j];
        }
    }

    printf("\n-------------------\n");
    printf(" array 1 :  ");
    printf("\n-------------------\n");
    
    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf(" %d ",array1[i][j]);
        }
        printf("\n");
    }


    printf("\n-------------------\n");
    printf(" array 2 :  ");
    printf("\n-------------------\n");
    
    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf(" %d ",array2[i][j]);
        }
        printf("\n");
    }
    
    printf("\n-------------------\n");
    printf("Sum Of array 1 and array 2 : ");
    printf("\n-------------------\n");
    
    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf(" %d ",sum[i][j]);
        }
        printf("\n");
    }


}