#include<stdio.h>

int main(){

    int row,col;

    printf("Enter Row Size : ");
    scanf("%d",&row);

    printf("Enter Col Size : ");
    scanf("%d",&col);

    int array[row][col];
    int Temp[row][col];

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf("Enter Element : ");
            scanf("%d",&array[i][j]);

            Temp[i][j] = -1;
        }
    }

    printf("\nMatrix:\n");

    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            printf("%d ",array[i][j]);
        }
        printf("\n");
    }

    printf("\nFrequency:\n");

    int counter;

    for(int i=0; i<row; i++){

        for(int j=0; j<col; j++){

            if(Temp[i][j] == -2){
                continue;
            }

            counter = 1;

            for(int k=0; k<row; k++){

                for(int t=0; t<col; t++){

                    if(i==k && j==t){
                        continue;
                    }

                    if(array[i][j] == array[k][t]){

                        counter++;
                        Temp[k][t] = -2;
                    }
                }
            }

            printf("%d -> %d\n",array[i][j],counter);
        }
    }

    return 0;
}