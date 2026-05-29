// Selection Sort

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

     printf("\n-------------------------\n");
     for(int i=0; i<array_size; i++){
         printf(" %d ",array[i]);
     }
     printf("\n-------------------------\n");

     for(int i=0; i<array_size-1; i++){
         int min_ind = i;

         for(int j=i+1; j<array_size; j++){
             if(array[min_ind] > array[j]){
                 min_ind = j;   
             }
         }

         int temp = array[i];
         array[i] = array[min_ind];
         array[min_ind] = temp;
     }

     printf("\nSorted Array:\n");
     printf("-------------------------\n");
     for(int i=0; i<array_size; i++){
         printf(" %d ",array[i]);
     }
     printf("\n-------------------------\n");

     return 0;
}