#include<stdio.h>

// 1 1 1 1 1
// 1 1 1 1
// 1 1 1
// 1 1
// 1

int main(){
    
    int n;

    printf("Enter n : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
        for(int j=i; j>=1; j--){
            printf("1");
        }
        printf("\n");
    }
}