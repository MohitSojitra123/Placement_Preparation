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

    printf("\nBefore Sorting:\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }

    // Bubble Sort
    for(int i=0; i<array_size-1; i++){
        for(int j=0; j<array_size-i-1; j++){
            if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }

    printf("\nAfter Bubble Sort:\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }

    return 0;
}