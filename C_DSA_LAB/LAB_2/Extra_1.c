// Write a program to remove duplicates from sorted array. 

#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
         printf("Enter Array Element : ");
         scanf("%d",&array[i]);
    }

     printf("\n----------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }

    printf("\n-----------------------\n");

    for(int i=0; i<array_size; i++){
        for(int j=i+1; j<array_size; j++){
            if(array[i]==array[j]){
                for(int k=j; k<array_size; k++){
                    array[k]=array[k+1];
                }
            }
            array_size--;
        }
    }

    printf("\n----------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n----------------------\n");

}