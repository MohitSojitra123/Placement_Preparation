// 1. Read n numbers in an array and print their sum and average. 

#include<stdio.h>

int main(){

    int array_size,sum=0;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
         printf("Enter Element : %d ",(i+1));
         scanf("%d",&array[i]);
         sum+=array[i];
    }

    printf("Sum Of Array Element : %d \n",sum);
    printf("Avg Of Array Element : %d \n",(sum/array_size));



}