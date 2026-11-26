// *
// **
// ***
// ****
// *****

#include<stdio.h>

int main(){
    
    int User_input;

    printf("Enter Any Number To Generate On Pattern : ");
    scanf("%d",&User_input);

    for(int i=1; i<=User_input; i++){
        for(int j=1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }

}