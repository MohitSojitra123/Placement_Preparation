#include<stdio.h>

// A B C D E
// A B C D
// A B C
// A B
// A

int main(){

    int n; 

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n-1; i>=0; i--){
        for(int j=0; j<=i; j++){
            printf("%c",'A'+j);
        }
        printf("\n");
    }

}