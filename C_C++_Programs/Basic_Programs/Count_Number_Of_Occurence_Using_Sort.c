#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i = 0; i < array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }

    printf("\n-------------------\n");
    for(int i = 0; i < array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n-------------------\n");

    for(int i = 0; i < array_size; i++){
        for(int j = i + 1; j < array_size; j++){
            if(array[i] > array[j]){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    int count = 1;

    for(int i = 1; i < array_size; i++){
        if(array[i - 1] == array[i]){
            count++;
        } else {
            printf("Element : %d -> %d\n", array[i - 1], count);
            count = 1;
        }
    }

    // Print last element count 
    printf("Element : %d -> %d\n", array[array_size - 1], count);

    return 0;
}
