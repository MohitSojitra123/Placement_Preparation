// Write a program to find common elements between two arrays. 

#include<stdio.h>

int main(){

    int array_size1,array_size2;

    printf("Enter Array Size 1 : ");
    scanf("%d",&array_size1);

    int array1[array_size1];

    for(int i=0; i<array_size1; i++){
        printf("Enter Array Element : %d ",(i+1));
        scanf("%d",&array1[i]);
    }

    printf("\n------------------\n");
    
    printf("Enter Array Size 2 : ");
    scanf("%d",&array_size2);   

    printf("\n------------------\n");

    int array2[array_size2];

    for(int i=0; i<array_size2; i++){
        printf("Enter Array Element : %d ",(i+1));
        scanf("%d",&array2[i]);
    }

    printf("\n------------------\n");

    for(int i=0; i<array_size1; i++){
        printf(" %d ",array1[i]);
    }

    printf("\n------------------\n");
    
    for(int i=0; i<array_size2; i++){
        printf(" %d ",array1[i]);
    }

    printf("\n------------------\n");
    printf("Comman Element : ");
    printf("\n------------------\n");
    
    for(int i=0; i<array_size1; i++){
        for(int j=0; j<array_size2; j++){
            if(array1[i] == array2[j]){
                printf(" %d ",array1[i]);
                continue;
            }
        }
    }
    printf("\n------------------\n");

}