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


     printf("\n-----------------------\n");
     for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
     }
     printf("\n-----------------------\n");
     
     for(int i=0; i<array_size; i++){
         for(int j=0; j<array_size-1-i; j++){
             if(array[j]>array[j+1]){
                 int temp=array[j];
                 array[j]=array[j+1];
                 array[j+1]=temp;
                }
            }
        }
        
                printf("\n-----------------------\n");
                for(int i=0; i<array_size; i++){
                    printf(" %d ",array[i]);
                }
                printf("\n-----------------------\n");


}