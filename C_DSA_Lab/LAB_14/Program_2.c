// Write a program to display n elements and sum of those elements using
// dynamic memory allocation. Also release the memory occupied after
// displaying.

#include<stdio.h>
#include<stdlib.h>

int main(){

    int array_size; 
    int sum=0;

    printf("Enter Size Of Array : ");
    scanf("%d",&array_size);

    int *ptr=(int *)malloc(array_size*sizeof(int));

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",(ptr+i));
        sum+=*(ptr+i);
    }

    for(int i=0; i<array_size; i++){
        printf("%d \n",*(ptr+i));
    }

    printf("Sum :  %d \n",sum);

    free(ptr);

}