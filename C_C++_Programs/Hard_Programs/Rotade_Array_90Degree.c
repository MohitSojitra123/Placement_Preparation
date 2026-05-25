#include<stdio.h>   

int main(){

    int row,col;

    printf("Enter Row : ");
    scanf("%d",&row);

    printf("Enter Col : ");
    scanf("%d",&col);

    int array[row][col];

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf("Enter Element : ");
            scanf("%d",&array[i][j]);
        }
        printf("\n");
    }

    printf("\n\n");

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
              printf("%d",array[i][j]);
        }
        printf("\n");
    }

    printf("\n\n");


    printf("\n\n");

    for(int i=0; i<row; i++){
        for(int j=col-1; j>=0; j--){
              printf("%d",array[j][i]);
        }
        printf("\n");
    }

    printf("\n\n");

}