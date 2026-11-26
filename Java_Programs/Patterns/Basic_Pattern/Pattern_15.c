#include<stdio.h>

// 5 5 5 5 5
// 4 4 4 4
// 3 3 3
// 2 2
// 1

int main(){

     int n;

     printf("Enter N : ");
     scanf("%d",&n);

     for(int i=n; i>=1; i--){
        for(int j=1; j<=i; j++){
            printf("%d",i);
        }
        printf("\n");
     }

}