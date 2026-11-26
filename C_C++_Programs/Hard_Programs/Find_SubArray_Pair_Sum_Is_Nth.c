#include<stdio.h>
#include<stdbool.h>

// Given an array arr[] of n integers and a target value, the task is to find whether there
// is a pair of elements in the array whose sum is equal to target.
// Input: arr[] = [0, -1, 2, -3, 1], target = -2
// Output: true
// Explanation: There is a pair (1, -3) with the sum equal to the given target, 1 + (-3) = -
// 2.
// Input: arr[] = [1, -2, 1, 0, 5], target = 0
// Output: false
// Explanation: There is no pair with sum equals to given target.

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }

    printf("\n\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n\n");

    int Nth;

   printf("Enter Nth Sum : ");
   scanf("%d",&Nth);

   bool  IsSumPosible=0;

   for(int i=0; i<array_size-1; i++){
        for(int j=i+1; j<array_size; j++){
            if((array[i]+array[j])==Nth){
                  IsSumPosible=1;
                  break;
            }
        }
   }

   if(IsSumPosible){
    printf("True : ");
   }else{
    printf("False : ");
   }

}