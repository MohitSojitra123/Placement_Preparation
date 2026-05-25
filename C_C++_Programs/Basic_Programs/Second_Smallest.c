#include<stdio.h>

int main(){

    int array_size;
    printf("Enter Array Size...");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element [%d]",i);
        scanf("%d",&array[i]);
    }

    int first_small=array[1],second_small=array[1];

     for(int i=0; i<array_size; i++){
        if(array[i]< first_small){
            first_small=array[i];
        }
     }

     for(int i=0; i<array_size; i++){
        if(array[i] != first_small){
             if(array[i] <  second_small){
                second_small=array[i];
             }
        }
     }

     printf("First Small Is => %d \n ",first_small);
     printf("Second Small Is =>  %d ",second_small);

}