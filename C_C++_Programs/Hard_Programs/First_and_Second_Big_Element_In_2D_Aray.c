#include<stdio.h>

int main(){

    int row,col;

    printf("Enter Row Size : ");
    scanf("%d",&row);

    printf("Enter COl Size : ");
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

    int first_big=array[0][0];
    int second_big=0;

        for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
             if(array[i][j]>first_big){
                  second_big=first_big;
                   first_big=array[i][j];
             }else if(array[i][j]>second_big && array[i][j] != first_big){
                  second_big=array[i][j];
             }
        }
        
    }


    printf("First Big : %d \n",first_big);
    printf("Second Big : %d \n",second_big);

}