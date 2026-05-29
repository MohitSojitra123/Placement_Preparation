// Write a program to find largest element in the array using Pointer. 

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

    printf("\n------------------\n");
    
    int *array_ptr=array;
    int max_value=*array_ptr;
    
    
    for(int i=0; i<array_size; i++){
        if(*(array_ptr+i) > max_value){
            max_value=*(array_ptr+i);
        }
    }

    printf("\n------------------\n");
     printf("Max Value Is : %d ",max_value);
    printf("\n------------------\n");

}