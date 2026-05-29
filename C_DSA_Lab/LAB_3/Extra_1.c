// Transpose Same Matrix 

#include<stdio.h>
 
int main(){
  
    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size][array_size];

     for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
           printf("Enter Array Element : ");
           scanf("%d",&array[i][j]);
        }
     }

     printf("\n-----------------------\n");
     
         for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("%d",array[i][j]);
        }
        printf("\n");
     }     

     printf("\n-----------------------\n");

     for(int i=0; i<array_size; i++){
        for(int j=i+1; j<array_size; j++){
               int temp=array[i][j];
               array[i][j]=array[j][i];
               array[j][i]=temp;
        }
     }

          printf("\n-----------------------\n");
     
         for(int i=0; i<array_size; i++){
        for(int j=0; j<array_size; j++){
            printf("%d",array[i][j]);
        }
        printf("\n");
     }     

     printf("\n-----------------------\n");

    
 }