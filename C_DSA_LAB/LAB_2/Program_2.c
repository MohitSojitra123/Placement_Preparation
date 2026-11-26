// 2. Write a program to find the largest element in an array.

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

    int max_ele=array[0];

    for(int i=0; i<array_size; i++){
        if(array[i]>max_ele){
            max_ele=array[i];
        }
    }

    printf("Max Element :  %d ",max_ele);

}