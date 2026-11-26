#include<stdio.h>

// A B C D E
// B C D E
// C D E
// D E
// E

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
             printf("%c",'A'+j);
        }
        printf("\n");
    }

}