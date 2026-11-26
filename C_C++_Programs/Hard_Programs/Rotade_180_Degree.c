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
    }

    printf("\n\n");
    
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf(" %d ",array[i][j]);
        }
        printf("\n");
    }
    
    printf("\n\n");

    int start_row=0;
    int end_row=row-1;

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
              if(start_row<=end_row){
                    int temp=array[start_row][j];
                    array[start_row][j]=array[end_row][j];
                    array[end_row][j]=temp;
              }
        }
        start_row++;
        end_row--;
    }

    start_row=0;
    end_row=row-1;

     for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
              if(start_row<=end_row){
                    int temp=array[j][start_row];
                    array[j][start_row]=array[j][end_row];
                    array[j][end_row]=temp;
              }
        }
        start_row++;
        end_row--;
    }


    printf("\n\n");
    
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf(" %d ",array[i][j]);
        }
        printf("\n");
    }
    
    printf("\n\n");



}