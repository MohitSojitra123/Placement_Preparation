#include<stdio.h>

int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i = 0; i < array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }

    printf("\n-------------------\n");
    for(int i = 0; i < array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n-------------------\n");

    int temp_array[array_size];
    int count=1;
    int i,j;

    for( i=0; i<array_size; i++){
        count=1;
        if(temp_array[i] == - 1){
            continue;
        }else{
              for( j=i+1; j<array_size; j++){
                    if(array[i]==array[j]){
                        count++;
                        temp_array[j] = -1;
                    }
              }
              printf("%d -> %d \n",array[i],count);
        }
    }



}