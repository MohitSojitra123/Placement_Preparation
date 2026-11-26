#include<stdio.h>

// Find the difference between the second largest element and the second smallest
// element of an array.
// Input : Enter the size of array: 7
// Enter 7 elements: 5 1 9 7 1 5 3
// Output: Difference: 4


    //   int small_1=INT_MAX;
    //   int small_2=INT_MAX;
    //   int big1=INT_MIN;
    //   int big2=INT_MIN;

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }

    printf("\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n");

    int first_largest=0,second_largest=0;

    for(int i=0; i<array_size; i++){
         if(array[i]>first_largest){
            second_largest=first_largest;
            first_largest=array[i];
         }else if(array[i]>second_largest && array[i] != first_largest){
              second_largest=array[i];
         }
    }

    printf("\n First Largest : %d ",first_largest);
    printf("\n Second Largest : %d ",second_largest);

    int first_smallest=array[0],second_smallest=array[0];

    for(int i=0; i<array_size; i++){
        if(array[i]<first_smallest){
           second_smallest=first_smallest;
           first_smallest=array[i];
        }else if(array[i] < second_smallest && array[i] != first_smallest){
            second_smallest=array[i];
        }
    }

    printf("\n First Smallest %d",first_smallest);
    printf("\n Second Smallest %d",second_smallest);

    printf("\n Difference Between Second Largest and Second Smallest %d",(second_largest-second_smallest));

}