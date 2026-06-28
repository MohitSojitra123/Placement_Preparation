#include<stdio.h>

// 5 5 5 5 5
// 5 5 5 5
// 5 5 5
// 5 5
// 5

int main(){

    int n;
    
    printf("Enter n :");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
        for(int j=1; j<=i; j++){
            printf("5");
        }
        printf("\n");
    }


}