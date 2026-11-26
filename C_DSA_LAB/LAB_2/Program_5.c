// Read n numbers in an array and print it in ascending order. 

#include<stdio.h>

int main(){
    
    int array_size,temp=0;

    printf("Enter Array Element : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }

    printf("\n----------------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n----------------------------\n");

    for(int i=0; i<array_size; i++){
        for(int j=i+1; j<array_size; j++){
             if(array[i]>array[j]){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
             }
        }
    }

    printf("\n----------------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n----------------------------\n");

}