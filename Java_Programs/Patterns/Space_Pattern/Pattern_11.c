#include<stdio.h>

// ************
// *****--*****
// ****----****
// ***------***
// **--------**
// *----------*
// *----------*
// **--------**
// ***------***
// ****----****
// *****--*****
// ************

int main(){


     int n;

    printf("Enter N : ");
    scanf("%d",&n);


     for(int i=n; i>=1; i--){

        for(int j1=i; j1>=1; j1--){
            printf("*");
        }

        for(int space=n; space>i; space--){
            printf("  ");
        }

        for(int j1=i; j1>=1; j1--){
            printf("*");
        }

        printf("\n");

    }


    for(int i=1; i<=n; i++){

        for(int j1=1; j1<=i; j1++){
            printf("*");
        }

        for(int space=i; space<n; space++){
          printf("  ");
        }

        for(int j1=1; j1<=i; j1++){
            printf("*");
        }

        printf("\n");

    }

       


}