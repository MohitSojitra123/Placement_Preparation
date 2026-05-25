#include<stdio.h>

// 1 1 1 1 1
// 2 2 2 2
// 3 3 3
// 4 4
// 5

int main(){
   
    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        for(int j=i; j<=n; j++){
            printf("%d",i);
        }
        printf("\n");
    }

}