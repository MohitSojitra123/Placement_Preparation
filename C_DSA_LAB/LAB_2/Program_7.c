// Write a program to remove duplicates from sorted array. 


#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : %d ",(i+1));
        scanf("%d",&array[i]);
    }


    printf("\n---------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
   printf("\n---------------------\n");

   for(int i=0; i<array_size; i++){
    if(array[i] == array[i+1]){
          for(int j=i+1; j<array_size; j++){
            array[j]=array[j+1];
          } 
          i--;
          array_size--;
    }
   }

    printf("\n---------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
   printf("\n---------------------\n");


}