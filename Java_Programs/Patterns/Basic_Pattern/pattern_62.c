#include<stdio.h>

// 1 1  2 1  3 1
// 1 2 2 2 3 2
// 1 3 2 3 3 3
// 1 4 2 4 3 4
// 1 5 2 5 3 5


int main(){

    int n; 

    printf("Enter N : ");
    scanf("%d",&n);

    int count=1;

    for(int i=1; i<=n; i++){
        int val=count;
         for(int j=1; j<=n; j++){
                printf(" %d ",val+=10);
         }
         count++;
         printf("\n");
    }

}