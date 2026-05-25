#include<stdio.h>


int main(){

    int row,col;

    printf("Enter Row Size : ");
    scanf("%d",&row);

    printf("Enter Col Size : ");
    scanf("%d",&col);

    int array[row][col];

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf("Enter Aray Element : ");
            scanf("%d",&array[i][j]);
        }
    }

    printf("\n\n");
    
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf(" %d ",array[i][j]);
        }
        printf("\n");
    }

    printf("\n\n");

    for(int j=0; j<col; j++){
          if(j==0 || j%2==0){
               for(int i=0; i<row; i++){
                printf(" %d ",array[i][j]);
               }
          }else{
            for(int i=col-1; i>=0; i--){
                printf(" %d ",array[i][j]);
            }
        }
    }

}