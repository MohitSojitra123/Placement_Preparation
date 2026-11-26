#include<stdio.h>

// A A A A A
// B B B B B
// C C C C C
// D D D D D
// E E E E E

int main(){

    char n;

    printf("Enter N : ");
    scanf("%c",&n);

   for(char i='A'; i<=n; i++){
    for(char j='A'; j<=n; j++){
        printf("%c",i);
    }
    printf("\n");
   }

}