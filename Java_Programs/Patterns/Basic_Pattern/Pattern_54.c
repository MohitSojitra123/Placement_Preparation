#include<stdio.h>

//          1
//      1 2 3
//   1 2 3 4 5 
// 1 2 3 4 5 6 7

int main(){

    int n; 

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){

        for(int space=n; space>i; space--){
            printf(" ");
        }

        for(int j=1;  j<=(i*2)-1; j++){
            printf("%d",j);
        }

        printf("\n");
    }

}