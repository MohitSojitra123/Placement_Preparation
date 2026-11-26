// Write a program to copy all the elements of one array to another array. 

#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array1[array_size];
    int copy_arr[array_size];

    for(int i=0; i<array_size; i++){
         printf("Enter Array Element : %d ",(i+1));
         scanf("%d",&array1[i]);
         copy_arr[i]=array1[i];
    }

    printf("\n------------------\n");
    for(int i=0; i<array_size; i++){
          printf(" %d ",copy_arr[i]);
    }
    printf("\n------------------\n");
}