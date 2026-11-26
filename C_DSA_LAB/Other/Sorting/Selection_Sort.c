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

    printf("\n--------------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n--------------------------\n");


    for(int i=0; i<array_size-1; i++){
        int min=i;
        for(int j=i+1; j<array_size; j++){
            if(array[j]<array[min]){
                min=j;
            }
        }

        int temp=array[min];
        array[min]=array[i];
        array[i]=temp;
    }


    printf("\n--------------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n--------------------------\n");

}