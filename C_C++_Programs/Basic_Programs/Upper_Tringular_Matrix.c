#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size...");
    scanf("%d",&array_size);

    int array[array_size][array_size];

    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("Enter Array Element =>  [%d][%d] ",i,j);
            scanf("%d",&array[i][j]);
        }
    }


    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
          if(i>j){
            array[i][j]=0;
          }else{
            array[i][j]=array[i][j];
          }
        }
    }



    for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
         printf("  %d",array[i][j]);
        }
      printf("\n");
    }
}