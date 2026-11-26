#include<stdio.h>

// 1
// 2 3
// 4 5 6
// 7 8 9 10
// 11 12 13 14 15
// 16 17 18 19 20 21 
// 22 23 24 25 26 27 28
// 29 30 31 32 33 34 35 36 
// 37 38 39


int main(){

    int n;
    int counter=1;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; counter<=n; i++){
            for(int j=i; j>=1 && counter<=n; j--){
                printf("%d",counter++);
            }
            printf("\n");
    }


}