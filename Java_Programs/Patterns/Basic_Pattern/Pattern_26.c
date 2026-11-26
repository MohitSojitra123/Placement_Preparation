#include<stdio.h>

// E
// D D
// C C C
// B B B B
// A A A A A

int main(){
    
    char ch;

    printf("Enter ch : ");
    scanf("%c",&ch);

    for(char i=ch; i>='a'; i--){
        for(char j=ch; j>=i; j--){
            printf("%c",i);
        }
        printf("\n");
    }

}