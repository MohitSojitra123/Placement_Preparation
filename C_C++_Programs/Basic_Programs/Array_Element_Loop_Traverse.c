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

    for(int i=0; i<array_size; i++){
        for(int j=1; j<=array[i]; j++){
            printf(" # ");
        }
        printf("\n");
    }

}