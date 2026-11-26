#include<stdio.h>

// 6 5 4 3 2 1 
// - 6 5 4 3 2 
// - - 6 5 4 3 
// - - - 6 5 4 
// - - - - 6 5 
// - - - - - 6

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        
        for(int space=1; space<i; space++){
            printf(" ");
        }

        for(int j=n; j>=i; j--){
            printf("%d",j);
        }

        printf("\n");
    }

}