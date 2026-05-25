#include<stdio.h>

// A A A A A
// B B B B B
// C C C C C
// D D D D D
// E E E E E

int main(){

    int n; 

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=0; i<n; i++){
         for(int j=0; j<=n; j++){
            printf("%c",'A'+i);
         }
         printf("\n");
    }

}