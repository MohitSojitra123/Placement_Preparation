#include<stdio.h>

// A
// B A
// C B A
// D C B A
// E D C B A

int main(){

    char ch;

    printf("Enter N : ");
    scanf("%c",&ch);

    for(char i = 'A'; i<=ch; i++){
        for(int j=i; j>='A'; j--){
            printf(" %c ",j);
        }
        printf("\n");
    }

}
