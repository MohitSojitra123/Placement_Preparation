#include<stdio.h>

// Given two sorted arrays, the task is to merge them in a sorted manner.
// Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
// Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
// Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
// Output: arr3[] = {4, 5, 7, 8, 8, 9} 

int main(){

    int array_size1,array_size2;

    printf("Enter Array Size 1 : ");
    scanf("%d",&array_size1);

    printf("Enter Array Size 2 : ");
    scanf("%d",&array_size2);

    int array1[array_size1];
    int array2[array_size2];

    for(int i=0; i<array_size1; i++){
        printf("Enter Array 1 Element : ");
        scanf("%d",&array1[i]);
    }

    for(int i=0; i<array_size2; i++){
        printf("Enter Array 2 Element : ");
        scanf("%d",&array2[i]);
    }

    int current_array_1_index=0;
    int current_array_2_index=0;

    int final_sorted_array[array_size1+array_size2];

    int i;

    for(i=0; i<(array_size1+array_size2); i++){

        if(current_array_1_index>=array_size1 ||
           current_array_2_index>=array_size2){
            break;
        }else{

            if(array1[current_array_1_index] <
               array2[current_array_2_index]){

                final_sorted_array[i] =
                array1[current_array_1_index];

                current_array_1_index++;

            }else{

                final_sorted_array[i] =
                array2[current_array_2_index];

                current_array_2_index++;
            }
        }
    }

    while(current_array_1_index < array_size1)
    {
        final_sorted_array[i] =
        array1[current_array_1_index];

        current_array_1_index++;
        i++;
    }

    while(current_array_2_index < array_size2)
    {
        final_sorted_array[i] =
        array2[current_array_2_index];

        current_array_2_index++;
        i++;
    }

    printf("\n---Final Sorted Array -----\n");

    for(int i=0; i<(array_size1+array_size2); i++){
        printf(" %d ",final_sorted_array[i]);
    }

    return 0;
}