#include<stdio.h>

// RW1
// RW2 RW2
// RW3 RW3 RW3
// RW4 RW4 RW4 RW4

int main(){

     int n;

     printf("Enter N : ");
     scanf("%d",&n);

     for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            printf("RW%d ",i);
        }
        printf("\n");
     }


}