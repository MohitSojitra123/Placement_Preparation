#include<stdio.h>

int main(){

    int array[]={10,20,30,40,50,60,70};

    int array_len=sizeof(array)/ sizeof(array[0]);

    printf("Array Size : %d ",array_len);

}