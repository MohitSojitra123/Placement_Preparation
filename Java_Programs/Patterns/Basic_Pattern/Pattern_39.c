#include<stdio.h>

// 0 1 0 1 0
// 1 0 1 0
// 0 1 0
// 1 0
// 0

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        for(int j=i; j<=5; j++){
            if(j%2!=0){
                printf("0");
            }else{
                printf("1");
            }
        }
        printf("\n");
    }

}