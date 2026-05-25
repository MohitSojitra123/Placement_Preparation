#include<stdio.h>

// 1 2 3 4 5 5 4 3 2 1
// 1 2 3 4 - - 4 3 2 1
// 1 2 3 - - - - 3 2 1
// 1 2 - - - - - - 2 1
// 1 - - - - - - - - 1


int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=5; i>=1; i--){

         for(int j1=1; j1<=i; j1++){
            printf("%d",j1);
         }

         for(int space1=i; space1<n; space1++){
            printf(" ");
         }

        for(int space1=i; space1<n; space1++){
            printf(" ");
         }

         for(int j2=i; j2>=1; j2--){
            printf("%d",j2);
         }

         printf("\n");
    }

}