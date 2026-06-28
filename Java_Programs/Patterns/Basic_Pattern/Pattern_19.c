#include<stdio.h>

// E
// E D
// E D C
// E D C B
// E D C B A

int main(){


    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n; i>=0; i--){
        for(int j=n; j>=i; j--){
            printf("%c",'A'+j);
        }
        printf("\n");
    }


}