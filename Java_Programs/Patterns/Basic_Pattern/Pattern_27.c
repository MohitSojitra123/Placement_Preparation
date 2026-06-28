#include<stdio.h>

// A A A A A
// B B B B
// C C C
// D D
// E


int main(){

    char ch;

    printf("Enter ch : ");
    scanf("%c",&ch);

    for(char i='a'; i<=ch; i++){
        for(char j=i; j<=ch; j++){
            printf("%c",i);
        }
        printf("\n");
    }

}