#include <stdio.h>

int main() {

    int row, col;

    printf("Enter Number of Rows : ");
    scanf("%d", &row);

    printf("Enter Number of Columns : ");
    scanf("%d", &col);

    int arr[row][col];


    printf("\nEnter Matrix Elements:\n");

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            printf("arr[%d][%d] : ", i, j);
            scanf("%d", &arr[i][j]);
        }
    }


    printf("\nMatrix:\n");

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            printf("%4d", arr[i][j]);
        }
        printf("\n");
    }

    int sum = 0;


    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {


            if(  (j == 0  && i<row) || (j==col-1  && i<row) || (i==0 && (j>0 && j<col-1))  || (i==row-1 && (j<col-1))  ) {
                sum += arr[i][j];
            }
        }
    }

    printf("\nBorder Sum = %d\n", sum);

    return 0;
}