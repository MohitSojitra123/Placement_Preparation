// Read n numbers in an array and print it using pointer. 

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

    printf("\n--------------------\n");
    
    int *array_ptr=array;
    
    for(int i=0; i<array_size; i++){
        printf(" %d ", *(array_ptr+i));
    }
    
    printf("\n--------------------\n");

}