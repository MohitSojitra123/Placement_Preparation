#include<stdio.h>

// 1
// 2 3
// 4 5 6
// 7 8 9 10
// 11 12 13 14 15

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    int count=0;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            count++;
            printf("%d",count);
        }
        printf("\n");
    }

}