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

   printf("\n\n");
   for(int i=0; i<array_size; i++){ 
       printf(" %d ",array[i]);
    }
    printf("\n\n");

   int position,newelement;

   printf("\nEnter Position To Insert Element : ");
   scanf("%d",&position);

   printf("\nEnter new Element :");
   scanf("%d",&newelement);

   ++array_size;

   for(int i=array_size-2; i>=position; i--){
            array[i+1]=array[i];
   }

   array[position]=newelement;

   printf("\n\n");
   for(int i=0; i<array_size; i++){ 
       printf(" %d ",array[i]);
    }
    printf("\n\n");


}