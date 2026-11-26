// Read two matrices, first 3x2 and second 2x3, perform multiplication operation
// and store result in third matrix and print it. 

#include<stdio.h>

int main(){

    int row1,col1,row2,col2;

    printf("Enter Array 1 Row Size : ");
    scanf("%d",&row1);

    printf("Enter Array 1 Col Size : ");
    scanf("%d",&col1);
    
    printf("\n--------------------------\n");
    
    
    printf("Enter Array 2 Row Size : ");
    scanf("%d",&row2);
    
    printf("Enter Array 2 Col Size : ");
    scanf("%d",&col2);
    
    printf("\n--------------------------\n");
    
    int matrix1[row1][col1];
    int matrix2[row2][col2];
    int multi_matrix[row1][col2];

    
        for(int i=0; i<row1; i++){
            for(int j=0; j<col1; j++){
                printf("Enter Matrix 1 Element : ");
                scanf("%d",&matrix1[i][j]);
            }
        }

        printf("\n--------------------------\n");
        
        for(int i=0; i<row2; i++){
            for(int j=0; j<col2; j++){
                printf("Enter Matrix 2 Element : ");
                scanf("%d",&matrix2[i][j]);
            }
        }

        printf("\n--------------------------\n");
        
        
        for(int i=0; i<row1; i++){
            for(int j=0; j<col1; j++){
                printf(" %d ",matrix1[i][j]);
            }
            printf("\n");
        }
        
        printf("\n--------------------------\n");

        
        for(int i=0; i<row2; i++){
            for(int j=0; j<col2; j++){
                printf(" %d ",matrix2[i][j]);
            }
            printf("\n");
        }

        printf("\n--------------------------\n");

    if(col1!=row2){
        printf("Matrix Multiplication Not Posible : ");
    }else{


        for(int i=0; i<row1; i++){
            for(int j=0; j<col2; j++){
                    multi_matrix[i][j]=0;
                for(int k=0; k<col1; k++){
                        multi_matrix[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }


        printf("\n--------------------------\n");
        
        for(int i=0; i<row1; i++){
            for(int j=0; j<col2; j++){
                printf(" %d ",multi_matrix[i][j]);
            }
            printf("\n");
        }

        printf("\n--------------------------\n");


    }

}