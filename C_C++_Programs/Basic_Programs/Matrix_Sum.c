#include<stdio.h>

int main(){
 
    int array_size;

    printf("Enter Array Size...");
    scanf("%d",&array_size);

    int matrix1[array_size][array_size],matrix2[array_size][array_size],sum[array_size][array_size];

    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
             printf("Enter Array Element matrix 1 [%d][%d]",i,j);
             scanf("%d",&matrix1[i][j]);
        }
    }

    printf("----------------------------------------\n");

       for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
             printf("Enter Array Element matrix 2 [%d][%d]",i,j);
             scanf("%d",&matrix2[i][j]);
        }
    }

    printf("----------------------------------------\n");


         for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
               sum[i][j]=matrix1[i][j] + matrix2[i][j];
        }
    }

    printf("matrix 1 \n");
   for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
             printf("%d",matrix1[i][j]);
        }
        printf("\n");
    }


    printf("matrix 2 \n");

       for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
             printf("%d",matrix2[i][j]);
        }
        printf("\n");
    }


    printf("Sum Of matrix 1 and matrix 2 \n");

        for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
             printf("%d",sum[i][j]);
        }
        printf("\n");
    }

    
}