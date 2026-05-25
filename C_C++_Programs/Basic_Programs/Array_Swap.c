#include<stdio.h>

int main(){

     int array_size;

     printf("Enter Array Size : ");
     scanf("%d",&array_size);

     int array[array_size];

     for(int i=0; i<array_size; i++){
         printf("Enter Array Element : %d ",(i+1));
         scanf("%d",&array[i]);
     }

    printf("\n----------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n----------------------\n");

    int index=array_size-1;
    int temp=0;

    for(int i=0; i<array_size; i++){
        
         if(i<index){
            temp=array[i];
            array[i]=array[index];
            array[index]=temp;
            index--;
         }
    }

    printf("\n----------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n----------------------\n");


}