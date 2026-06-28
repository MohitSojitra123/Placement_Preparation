#include<stdio.h>

// 0
// 2 4
// 6 8 10
// 12 14 16 18

int main(){

     int n;

    printf("Enter N : ");
    scanf("%d",&n);

    int num=0;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            printf(" %d ",num);
            num+=2;
        }
        printf("\n");
    }


}