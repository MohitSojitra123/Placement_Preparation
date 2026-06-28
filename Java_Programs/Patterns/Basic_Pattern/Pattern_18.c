#include<stdio.h>

// A
// A B
// A B C
// A B C D
// A B C D E

int main(){

    int n; 

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            printf("%c",'A'+i);
        }
        printf("\n");
    }

}