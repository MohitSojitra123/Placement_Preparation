#include<stdio.h>

int main(){

    int row,col;

    printf ("Enter Size Of 2D array...");
    scanf("%d",&row);

    col=row;

    int array[row][col],sum=0;

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
              printf("Enter Array Element [%d][%d]", i,j);
              scanf("%d",&array[i][j]);
        }
    }

        for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
             printf("%d  ",array[i][j]);
             if(j==i){
                sum+=array[i][j];
             }
        }
        printf("\n");
    }



    printf("Sum Of Diagonql Value => %d  ", sum);



}