#include<stdio.h>

// A
// B B
// C C C
// D D D D
// E E E E E

int main(){

    char ch;

    printf("Enter ch : ");
    scanf("%c",&ch);

    for(char i='a'; i<=ch; i++){
        for(char j='a'; j<=i; j++){
            printf("%c",i);
        }
        printf("\n");
    }


}