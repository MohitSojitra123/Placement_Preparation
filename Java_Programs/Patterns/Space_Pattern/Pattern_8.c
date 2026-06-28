#include<stdio.h>

//  * * * * * * * * *
//    * * * * * * *
//      * * * * *
//        * * *
//          *

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
        
        for(int space=n; space>i; space--){
            printf(" ");
        }

        for(int j=1; j<=(i*2)-1; j++){
            printf("*");
        }

        printf("\n");

    }

}