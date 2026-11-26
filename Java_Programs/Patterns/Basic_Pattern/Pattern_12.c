#include<stdio.h>

// 1
// 2 2
// 3 3 3
// 4 4 4 4
// 5 5 5 5 5

int main(){

      int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            printf("%d ",i);
        }
        printf("\n");
    }

}