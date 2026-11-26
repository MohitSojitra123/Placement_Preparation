#include<stdio.h>

int main(){

     int array_size;

     printf("Enter Array Size : ");
     scanf("%d",&array_size);

     int array[array_size];
     int visited_array[array_size];

    for(int i=0; i<array_size; i++){
       printf("Enter Array Element : %d ->  ",(i+1));
       scanf("%d",&array[i]);     
    }

    printf("\n---------------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n---------------------\n");

    for(int i=0; i<array_size; i++){
        visited_array[i]=0;
    }

    int count=1;

    for(int i=0; i<array_size; i++){
          if(visited_array[i] == -1){
            continue;
          }else{
             for(int j=i+1; j<array_size; j++){
                 if(array[i] == array[j]){
                    count++;
                    visited_array[j]=-1;
                 }
             }
             if(count>1){
                printf("Duplicate Element :  %d -> %d ",array[i],count);
                count=1;
             }
          }
    }



}