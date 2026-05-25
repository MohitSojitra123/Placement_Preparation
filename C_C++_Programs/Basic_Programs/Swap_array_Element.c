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

    int last_index=array_size-1;
    int first_index=0;

    while (first_index<=last_index)
    {
          int temp=array[first_index];
          array[first_index]=array[last_index];
          array[last_index]=temp; 
          first_index++;
          last_index--;
    }

    printf("\n-------------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n-------------------------\n");

}