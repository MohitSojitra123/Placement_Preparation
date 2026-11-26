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

     int first_largest=array[0];
     int second_largest=0;


     for(int i=1; i<array_size; i++){
         if(array[i]>first_largest){
            second_largest=first_largest;
            first_largest=array[i];
         }
         if(array[i]>second_largest && array[i] != first_largest){
            second_largest=array[i];
         }
     }

     printf("%d",second_largest);


}