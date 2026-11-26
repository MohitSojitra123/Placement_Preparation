// 1. Write a program to get n elements of an array from user and print those
// elements using pointer.

#include <stdio.h>
#include <stdlib.h>   

int main() {

     int array_size;

     printf("Enter Array Size : ");
     scanf("%d",&array_size);

     int arr[array_size];

     for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&arr[i]);
     }

     int *ptr=arr;

     for(int i=0; i<array_size; i++){
        printf("%d \n",*(ptr+i));
     }

}
