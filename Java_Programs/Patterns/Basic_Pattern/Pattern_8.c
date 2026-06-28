#include<stdio.h>

// 1
// 1 1
// 1 1 1
// 1 1 1 1
// 1 1 1 1 1

int main(){

    int n;

    printf("Enter n : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            printf("1");
        }
        printf("\n");
    }

}