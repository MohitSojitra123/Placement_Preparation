#include<stdio.h>

// ----1
// ---121
// --12321
// -1234321
// 123454321

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){

        for(int space=i; space<n; space++){
            printf(" ");
        }

      
        for(int j1=1; j1<=i; j1++){
            printf("%d",j1);
        }

        for(int j2=i-1; j2>=1; j2--){
            printf("%d",j2);
        }


        printf("\n");
    }

}